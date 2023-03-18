package proect.covidstats.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "countries")
public class Country {

    /*
     * Country class represents the COVID-19 data for a specific country.
     * It contains information about the country's name, country code, slug, new/total confirmed cases,
     * new/total deaths, new/total recovered cases, and the date and time the data was last updated.
     * This class is used to store country data in CovidData class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;
    private UUID ID;
    private String country;
    @Column(length = 2)
    private String countryCode;
    private String slug;
    private Integer newConfirmed;
    private Long totalConfirmed;
    private Integer newDeaths;
    private Long totalDeaths;
    private Integer newRecovered;
    private Long totalRecovered;
    private Instant date;

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public UUID getID() {
        return ID;
    }
}