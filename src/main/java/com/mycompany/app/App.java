package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    void writeToFile(List<String> strings){
        log.debug("start");
        try (PrintWriter writer = new PrintWriter("target/output.txt")) {
            for (String str : strings) {
                writer.println(str);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.debug("finish");

    }
//
    public static void main(String[] args ) throws IOException {
        App app = new App();
        //app.sort("C:\\projects\\unsorted.txt", "C:\\projects\\testSorted.txt");
        app.dateSort("src/test/resources/dates.txt","src/test/resources/datesSorted.txt");
    }

    void dateSort(String sourceFile, String sortedFile) throws IOException {
        List<String> strings = new ArrayList<>();
        List<Date> dates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                strings.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (String dateString : strings) {
            try {
                dates.add(simpleDateFormat.parse(dateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Collections.sort(dates);
            FileWriter writer = new FileWriter(sortedFile);
            for(Date d: dates) {
                writer.write(simpleDateFormat.format(d) + System.lineSeparator());
            }
            writer.close();

    }

    }


    void sort(String sourceName, String sortedName){
        List<String> strings;
        try (Stream<String> lines = Files.lines(Paths.get(sourceName))) {
            strings = lines.collect(Collectors.toList());
            java.util.Collections.sort(strings);
            FileWriter writer = new FileWriter(sortedName);
            for(String str: strings) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("SameParameterValue")
    int sum(String fileName) {
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine = br.readLine();
            String[] s = sCurrentLine.split(" ");
            int [] arr = new int [s.length];
            for(int i=0; i<s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            sum = IntStream.of(arr).sum();
            log.debug("Line - {}", sum);
        } catch (IOException e) {
           log.error(e.getMessage());
        }
        return sum;
}}
