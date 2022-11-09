package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate){
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }
    private int getNumberOfPayments(){
        return termInYears * 12;
    }
    private float getMonthlyInterestRate(){
        float interestRate = annualRate/100;
        return interestRate/12;
    }
    public void calculateMonthlyPayment(){
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        long P = loanAmount;
        double M = P*(r*Math.pow((1+r),n)/(Math.pow((1+r),n)-1));
        this.monthlyPayment = M;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("####0.00"); /* This means that if a digit is 0 in place where # occurs,
                                                                    do not show 0.
                                                                    When the digit is 0 in place where 0 occurs,
                                                                    show 0, don't hide it. */
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);
        MortgageCalculator calculator = new MortgageCalculator(loanAmount,termInYears,annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }
}

