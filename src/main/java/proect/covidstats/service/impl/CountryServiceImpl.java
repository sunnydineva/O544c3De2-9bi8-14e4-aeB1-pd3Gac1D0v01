package proect.covidstats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proect.covidstats.convertor.CountryConvertor;
import proect.covidstats.dto.CountryResponse;
import proect.covidstats.exception.RecordNotFoundException;
import proect.covidstats.repository.CountryRepository;
import proect.covidstats.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryConvertor convertor;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryConvertor convertor) {
        this.countryRepository = countryRepository;
        this.convertor = convertor;
    }

    @Override
    public CountryResponse getByCode(String countryCode) {
        return convertor.toResponse(countryRepository
                .getByCountryCode(countryCode)
                .orElseThrow(()->new RecordNotFoundException(
                        String.format("Country with code %s not found", countryCode))));
    }
}
