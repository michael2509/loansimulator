package fr.formation.loansimulator.simulator;

import java.util.ArrayList;

public class AmortizationTable {
    private int duration;
    private ArrayList<LoanPeriod> periodList;

    public AmortizationTable(int duration, ArrayList<LoanPeriod> periodList) {
        this.duration = duration;
        this.periodList = periodList;
    }

    public int getPeriod() {
        return duration;
    }

    public void setPeriod(int period) {
        this.duration = period;
    }

    public ArrayList<LoanPeriod> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(ArrayList<LoanPeriod> periodList) {
        this.periodList = periodList;
    }
}
