package com.gevak.rest.util;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.gevak.rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvProcessingUtil {


    private final static String TEMP_CSV_NAME_PATTERN = "temp-csv-%s";
    private static final CharSequence COMMA_LABEL = ";";

    /*Returns initial line to array broken down on parameters*/
    public static Map<String, List<String>> parseCsvFile(MultipartFile file) {
        try(InputStream inputStream = file.getInputStream()) {
            return parseCsvFile(inputStream, false);
        } catch (Exception e) {
            throw new RuntimeException("File reading exception");
        }
    }

    public static Map<String, List<String>> parseCsvFile(File file, boolean checkRowSize) throws IOException {
        return parseCsvFile(new FileInputStream(file), checkRowSize);
    }

    public static Map<String, List<String>> parseCsvFile(InputStream fileStream) throws IOException {
        return parseCsvFile(fileStream, false);
    }

    public static Map<String, List<String>> parseCsvFile(InputStream fileStream, boolean checkRowSize) throws IOException {

        Map<String, List<String>> result = new LinkedHashMap<>();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(fileStream), ';')) {
            String[] row = csvReader.readNext();

            int headerRowSize = row.length;
            do {
                List<String> values = Arrays.stream(row).map(String::trim).collect(Collectors.toList());
//                System.out.println(values+" dsfsdfsdfsdfdfsdf");
//                for (String s : values) {
////
//                    String departmentCode = values.get(0);
//                    /*Найменування підрозділу*/
//                    String departmentName= values.get(1);
//                    /*Код посади*/
//                    String positionCode= values.get(2);
//                    /*Код ОВТ або МТЗ*/
//                    String ovtMtzCode= values.get(3);
//                    /*Найменування посади ОВТ або МТЗ*/
//                    String ovtMtzName= values.get(4);
//                    /*Код звання*/
//                    String rankCode= values.get(5);
//                    /*Найменування звання*/
//                    String rankName= values.get(6);
//                    /*Кількість штат*/
//                    String amount= values.get(7);
//                    /*Одиниця виміру*/
//                    String unit= values.get(8);
//                    System.out.println(amount);
//                    System.out.println(unit);
////                    System.out.println();
//
//                }
                String csvRecord = values.stream().collect(Collectors.joining(COMMA_LABEL));
                result.put(csvRecord, values);
                if (checkRowSize && values.size() != headerRowSize) {
                    throw new IllegalArgumentException(String.format("Invalid columns size in record: %s", csvRecord));
                }
            } while ((row = csvReader.readNext()) != null);
        }
        return result;
    }

    public static void writeToCsvFile(File file, List<String[]> items) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))){
            csvWriter.writeAll(items);
        }
    }

}
