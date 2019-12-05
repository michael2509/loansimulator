package fr.formation.loansimulator.simulator;

import java.math.BigDecimal;

public abstract class LoanPeriod {

    protected BigDecimal depreciatedCapital;
    protected BigDecimal interest;
    protected BigDecimal remainingCapital;
    protected BigDecimal insurance;
    protected BigDecimal totalCost;

    public BigDecimal getDepreciatedCapital() {
        return depreciatedCapital;
    }

    public void setDepreciatedCapital(BigDecimal depreciatedCapital) {
        this.depreciatedCapital = depreciatedCapital;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getRemainingCapital() {
        return remainingCapital;
    }

    public void setRemainingCapital(BigDecimal remainingCapital) {
        this.remainingCapital = remainingCapital;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
