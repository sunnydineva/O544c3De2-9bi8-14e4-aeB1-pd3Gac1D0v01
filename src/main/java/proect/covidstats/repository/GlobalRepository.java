package proect.covidstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proect.covidstats.entity.Global;

@Repository
public interface GlobalRepository extends JpaRepository<Global, Long> {
}
