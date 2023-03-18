package proect.covidstats.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Premium {
    @Id
    private UUID ID;
}
