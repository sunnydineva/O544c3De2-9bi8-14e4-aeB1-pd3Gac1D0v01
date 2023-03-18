package proect.covidstats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Builder
@Getter
@Setter
public class CountryResponse {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Slug")
    private String slug;

    @JsonProperty("NewConfirmed")
    private Integer newConfirmed;

    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;

    @JsonProperty("NewDeaths")
    private Integer newDeaths;

    @JsonProperty("TotalDeaths")
    private Long totalDeaths;

    @JsonProperty("NewRecovered")
    private Integer newRecovered;

    @JsonProperty("TotalRecovered")
    private Long totalRecovered;

    @JsonProperty("Date")
    private Instant date;
}
