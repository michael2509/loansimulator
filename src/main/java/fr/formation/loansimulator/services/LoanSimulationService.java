package fr.formation.loansimulator.services;

import fr.formation.loansimulator.dtos.LoanSimulationDto;
import fr.formation.loansimulator.simulator.AmortizationTable;

public interface LoanSimulationService {

    void saveLoanRequest(LoanSimulationDto dto);
    AmortizationTable getSimulationResult(LoanSimulationDto loanSimulationDto);
}
