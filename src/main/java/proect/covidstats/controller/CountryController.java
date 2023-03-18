package proect.covidstats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proect.covidstats.dto.CountryResponse;
import proect.covidstats.service.CountryService;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/{countryCode}")
    ResponseEntity<CountryResponse> getByCode(@PathVariable String countryCode) {
        if (!countryCode.chars().allMatch(Character::isUpperCase)) {
            throw new IllegalArgumentException("Country code should be in uppercase letters");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countryService.getByCode(countryCode));
    }
}
