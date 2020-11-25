package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.CostCentre;
import ch.zli.m223.punchclock.service.CostCentreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/costCenters")
public class CostCentreController {

    private CostCentreService costCentreService;

    public CostCentreController(CostCentreService costCentreService) {
        this.costCentreService = costCentreService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CostCentre> getAllCostCenters() {
        return costCentreService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CostCentre createCostCentre(@Valid @RequestBody CostCentre costCentre) {
        return costCentreService.createCostCentre(costCentre);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCostCentre(@PathVariable Long id) {
        costCentreService.deleteCostCentre(id);
    }
}
