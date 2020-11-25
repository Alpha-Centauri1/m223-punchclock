package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.CostCentre;
import ch.zli.m223.punchclock.repository.CostCentreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCentreService {

    private CostCentreRepository costCentreRepository;

    public CostCentreService(CostCentreRepository costCentreRepository) {
        this.costCentreRepository = costCentreRepository;
    }

    public CostCentre createCostCentre(CostCentre costCentre) {
        return costCentreRepository.saveAndFlush(costCentre);
    }

    public List<CostCentre> findAll() {
        return costCentreRepository.findAll();
    }

    public void deleteCostCentre(Long id) {
        costCentreRepository.deleteById(id);
    }
}
