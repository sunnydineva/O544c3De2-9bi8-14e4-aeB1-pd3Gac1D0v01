package proect.covidstats.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "covid_data")
public class CovidData {

    /*
    CovidData class represents the ID and Message returned from the COVID-19 API.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "covid_data_id")
    private Long id;
    //private UUID ID;
    private String ID;
    private String message;
}

