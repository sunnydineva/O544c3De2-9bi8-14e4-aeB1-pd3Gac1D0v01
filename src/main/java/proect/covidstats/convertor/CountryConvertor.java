package proect.covidstats.convertor;

import org.springframework.stereotype.Component;
import proect.covidstats.dto.CountryResponse;
import proect.covidstats.entity.Country;

@Component
public class CountryConvertor {

    public CountryResponse toResponse(Country country){
        return  CountryResponse.builder()
                .country(country.getCountry())
                .countryCode(country.getCountryCode())
                .slug(country.getSlug())
                .newConfirmed(country.getNewConfirmed())
                .totalConfirmed(country.getTotalConfirmed())
                .newDeaths(country.getNewDeaths())
                .totalDeaths(country.getTotalDeaths())
                .newRecovered(country.getNewRecovered())
                .totalRecovered(country.getTotalRecovered())
                .date(country.getDate())
                .build();
    }
}
