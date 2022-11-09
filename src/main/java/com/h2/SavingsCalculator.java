package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;
    public SavingsCalculator(float[] credits,float[] debits){
        this.credits = credits;
        this.debits = debits;
    }
    private float sumOfCredits(){
        float sum = 0.0f;
        for(float credit : credits){
            sum += credit;
        }
        return sum;
    }
    private float sumOfDebits(){
        float sum = 0.0f;
        for(float debit : debits){
            sum += debit;
        }
        return sum;
    }
    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }
    public float calculate(){
        float creditSum = sumOfCredits();
        float debitSum = sumOfDebits();
        float netSavings = creditSum - debitSum;
        return netSavings;
    }

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");
        float[] credits = new float[creditsAsString.length];
        for(int i = 0; i<creditsAsString.length; i++){
            float currentCredit = Float.parseFloat(creditsAsString[i]);
            credits[i] = currentCredit;
        }
        float[] debits = new float[debitsAsString.length];
        for(int i = 0; i<debitsAsString.length; i++){
            float currentDebit = Float.parseFloat(debitsAsString[i]);
            debits[i] = currentDebit;
        }
        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
