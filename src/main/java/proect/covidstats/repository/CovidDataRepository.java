package proect.covidstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proect.covidstats.entity.CovidData;

@Repository
public interface CovidDataRepository extends JpaRepository<CovidData, Long> {
}
