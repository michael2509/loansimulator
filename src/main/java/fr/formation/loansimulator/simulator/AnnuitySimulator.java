package fr.formation.loansimulator.simulator;

import fr.formation.loansimulator.dtos.LoanSimulationDto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AnnuitySimulator extends Simulator {

    private static final BigDecimal ZERO = new BigDecimal(0);
    private static final BigDecimal ONE = new BigDecimal(1);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private static final MathContext mc = new MathContext(2, RoundingMode.HALF_UP);

    BigDecimal calculateAnnuity(BigDecimal totalCapital, BigDecimal interestRate, int duration) {
        BigDecimal lowerIR = interestRate.divide(ONE_HUNDRED);
        BigDecimal higherIR = lowerIR.add(ONE);

        BigDecimal annuity = totalCapital.multiply(lowerIR).divide(ONE.subtract(ONE.divide(higherIR.pow(duration), mc)), mc).setScale(2, RoundingMode.HALF_UP);
        return annuity;
    }

    @Override
    BigDecimal calculateInterest(BigDecimal remainingCapital, BigDecimal loanRate) {
        BigDecimal interest = remainingCapital.multiply(loanRate).divide(ONE_HUNDRED, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        return interest;
    }

    @Override
    BigDecimal calculateDepreciatedCapital(BigDecimal annuity, BigDecimal interest) {
        BigDecimal depreciatedCapital = annuity.subtract(interest).setScale(2, RoundingMode.HALF_UP);
        return  depreciatedCapital;
    }

    @Override
    BigDecimal calculateInsurance(BigDecimal totalCapital, BigDecimal insuranceRate) {
        BigDecimal insurance = totalCapital.multiply(insuranceRate).divide(ONE_HUNDRED).setScale(2, RoundingMode.HALF_UP);
        return insurance;
    }

    @Override
    BigDecimal calculateRemainingCapital(BigDecimal totalCapital, BigDecimal depreciatedCapital) {
        BigDecimal remainingCapital = totalCapital.subtract(depreciatedCapital).setScale(2, RoundingMode.HALF_UP);
        return remainingCapital;
    }

    @Override
    BigDecimal calculateTotalCost(BigDecimal annuity, BigDecimal insurance) {
        BigDecimal totalCost = annuity.add(insurance).setScale(2, RoundingMode.HALF_UP);
        return totalCost;
    }

    @Override
    public AmortizationTable simulationResult(LoanSimulationDto loanSimulationDto) {

        int duration = loanSimulationDto.getDuration();
        BigDecimal remainingCapital = loanSimulationDto.getAmount();
        ArrayList<LoanPeriod> annuities = new ArrayList<LoanPeriod>();

        while (duration > 0) {
            BigDecimal interest = calculateInterest(remainingCapital, loanSimulationDto.getLoanRate());
            BigDecimal annuityAmount = calculateAnnuity(loanSimulationDto.getAmount(), loanSimulationDto.getLoanRate(), loanSimulationDto.getDuration());
            BigDecimal depreciatedCapital = calculateDepreciatedCapital(annuityAmount, interest);
            remainingCapital = calculateRemainingCapital(remainingCapital, depreciatedCapital);

            if (remainingCapital.compareTo(BigDecimal.ZERO) < 0) {
                remainingCapital = BigDecimal.valueOf(0);
            }

            BigDecimal insurance = calculateInsurance(loanSimulationDto.getAmount(), loanSimulationDto.getInsuranceRate());
            BigDecimal totalCost = calculateTotalCost(annuityAmount, insurance);

            LoanPeriod annuity = new Annuity(depreciatedCapital, interest, remainingCapital, annuityAmount, insurance, totalCost);
            annuities.add(annuity);

            duration--;
        }

        AmortizationTable simulationResult = new AmortizationTable(loanSimulationDto.getDuration(), annuities);
        return simulationResult;
    }
}
