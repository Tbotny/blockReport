# Block.io Report

This program allows you to save Block.io wallets report to a CSV file.

## How to use

1. Clone repository
2. Create folder "C:\\report"
3. Run project

## Class Report
### Constructor
```aidl
public Report(String apiKey)
```
Parameters:
apiKey - Block.io ApiKey

### Method Detail
```aidl
public void createCSV(String path)
```
Parameters:

path - Full path and filename with csv extension. The path must be to an existing folder. Example "c:\\report\\btc.csv"

```aidl
public void createCSV(String path, double minAmount)
```
Parameters:

path - Full path and filename with csv extension. The path must be to an existing folder. Example "c:\\report\\btc.csv"

minAmount - Filter the wallets with balance greater than the specified amount