package org.example;

import java.util.ArrayList;
import java.util.List;


public class Report {
    private static final String[] TABLE_HEADER = {"Currency", "address", "ballance"}; // typo in ballance according to requirements
    private final BlockApi blockApi;

    public Report(String apiKey) {
        this.blockApi = new BlockApi(apiKey);
    }

    public void createCSV(String path) {
        createCSV(path, -1);
    }

    public void createCSV(String path, double minAmount) {
        FileManager.writeToCSV(path, getTableRows(blockApi.getAddresses(), minAmount));
    }

    private List<String[]> getTableRows(AddressResponse addressResponse, double minAmount) {
        List<String[]> rows = new ArrayList<>();
        rows.add(TABLE_HEADER);

        addressResponse.data.addresses
                .stream()
                .filter(address -> Double.parseDouble(address.available_balance) > minAmount)
                .forEach(address -> {
                    rows.add(new String[]{
                            addressResponse.data.network,
                            address.address,
                            address.available_balance.substring(0, address.available_balance.length() - 4)
                    });
                });

        return rows;
    }
}
