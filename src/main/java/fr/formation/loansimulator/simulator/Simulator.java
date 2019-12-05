package fr.formation.loansimulator.simulator;

import fr.formation.loansimulator.dtos.LoanSimulationDto;

import java.math.BigDecimal;

public abstract class Simulator {
    abstract BigDecimal calculateInterest(BigDecimal remainingCapital, BigDecimal loanRate);
    abstract BigDecimal calculateDepreciatedCapital(BigDecimal annuity, BigDecimal interest);
    abstract BigDecimal calculateInsurance(BigDecimal amount, BigDecimal insuranceRate);
    abstract BigDecimal calculateRemainingCapital(BigDecimal amount, BigDecimal depreciatedCapital);
    abstract BigDecimal calculateTotalCost(BigDecimal annuity, BigDecimal insurance);

    public abstract AmortizationTable simulationResult(LoanSimulationDto loanSimulationDto);
}
