package fr.formation.loansimulator.controllers;

import fr.formation.loansimulator.dtos.LoanSimulationDto;
import fr.formation.loansimulator.simulator.AmortizationTable;
import fr.formation.loansimulator.services.LoanSimulationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/loan-simulation")
public class LoanSimulationController {

    private LoanSimulationService loanSimulationService;

    public LoanSimulationController(LoanSimulationService loanSimulationService) {
        this.loanSimulationService = loanSimulationService;
    }

    @PostMapping
    protected AmortizationTable getAmortizationTable(@Valid @RequestBody LoanSimulationDto dto) {
        AmortizationTable amortizationTable = loanSimulationService.getSimulationResult(dto);
        return amortizationTable;
    }
}
