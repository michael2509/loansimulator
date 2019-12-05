package fr.formation.loansimulator.services;

import fr.formation.loansimulator.dtos.LoanSimulationDto;
import fr.formation.loansimulator.entities.LoanSimulation;
import fr.formation.loansimulator.repositories.LoanSimulationRepository;
import fr.formation.loansimulator.simulator.AmortizationTable;
import fr.formation.loansimulator.simulator.AnnuitySimulator;
import org.springframework.stereotype.Service;

@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {

    private final LoanSimulationRepository loanSimulationRepo;

    public LoanSimulationServiceImpl(LoanSimulationRepository loanSimulationRepo) {
        this.loanSimulationRepo = loanSimulationRepo;
    }

    @Override
    public void saveLoanRequest(LoanSimulationDto dto) {
        LoanSimulation loanSimulation = new LoanSimulation();
        loanSimulation.setAmount(dto.getAmount());
        loanSimulation.setDuration(dto.getDuration());
        loanSimulation.setInsuranceRate(dto.getInsuranceRate());
        loanSimulation.setLoanRate(dto.getLoanRate());
        loanSimulation.setLoanType(dto.getLoanType());
        loanSimulation.setStartDate(dto.getStartDate());

        loanSimulationRepo.save(loanSimulation);
    }

    @Override
    public AmortizationTable getSimulationResult(LoanSimulationDto loanSimulationDto) {
        saveLoanRequest(loanSimulationDto);

        AnnuitySimulator simulation = new AnnuitySimulator();
        AmortizationTable simulationResult = simulation.simulationResult(loanSimulationDto);
        return simulationResult;
    }
}
