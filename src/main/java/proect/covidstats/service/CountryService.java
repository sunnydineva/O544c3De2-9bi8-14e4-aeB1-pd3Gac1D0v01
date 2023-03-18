package proect.covidstats.service;

import org.springframework.stereotype.Service;
import proect.covidstats.dto.CountryResponse;

@Service
public interface CountryService {

    CountryResponse getByCode(String countryCode);

}
