package org.example;

public class Main {
    public static void main(String[] args) {
        Report reportBitcoin = new Report("227f-10b2-6a72-a97d");
        reportBitcoin.createCSV("c:\\BitcoinAll.csv");
        reportBitcoin.createCSV("c:\\BitcoinNonZero.csv",  0);
        reportBitcoin.createCSV("c:\\BitcoinGraterThen0,0001.csv",  0.0001);

        System.exit(0);
    }
}
