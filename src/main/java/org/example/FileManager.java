package org.example;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public static void writeToCSV(String path, List<String[]> rows) {
        try (ICSVWriter writer = new CSVWriterBuilder(new FileWriter(path))
                .withSeparator(',')
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .build()
        ) {
            writer.writeAll(rows);
            System.out.println("Report saved to " + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
