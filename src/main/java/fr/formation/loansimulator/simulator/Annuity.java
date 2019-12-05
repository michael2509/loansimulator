package fr.formation.loansimulator.simulator;

import java.math.BigDecimal;

public class Annuity extends LoanPeriod {

    public Annuity(BigDecimal depreciatedCapital, BigDecimal interest, BigDecimal remainingCapital, BigDecimal annuity, BigDecimal insurance, BigDecimal totalCost) {
        this.depreciatedCapital = depreciatedCapital;
        this.interest = interest;
        this.remainingCapital = remainingCapital;
        this.insurance = insurance;
        this.totalCost = totalCost;
        this.annuity = annuity;
    }

    private BigDecimal annuity;

    public BigDecimal getAnnuity() {
        return annuity;
    }

    public void setAnnuity(BigDecimal annuity) {
        this.annuity = annuity;
    }
}
