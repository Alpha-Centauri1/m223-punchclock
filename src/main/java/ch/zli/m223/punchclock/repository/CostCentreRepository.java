package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.CostCentre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCentreRepository extends JpaRepository<CostCentre, Long> {
}
