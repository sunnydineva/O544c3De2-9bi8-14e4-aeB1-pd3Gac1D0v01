package proect.covidstats.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name =  "global_data")
public class Global {

    /*
     Global class represents the global COVID-19 data.
     It contains information about new/total confirmed cases, new/total deaths, new/total recovered cases, and the date and time the data was last updated.
     This class is used to store global data in CovidData class.
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "global_id")
    private Long id;

    @Column(name = "new_confirmed")
    private Integer newConfirmed;

    @Column(name = "total_confirmed")
    private Long totalConfirmed;

    @Column(name = "new_deaths")
    private Integer newDeaths;

    @Column(name = "total_deaths")
    private Long totalDeaths;

    @Column(name = "new_recovered")
    private Integer newRecovered;

    @Column(name = "total_recovered")
    private Long totalRecovered;

    @Column(name = "last_updated")
    private Instant date;

}
