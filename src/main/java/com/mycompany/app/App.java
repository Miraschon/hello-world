package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

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

    public static void main(String[] args ) {
        App app = new App();
        app.sum("C:\\projects\\hello-world\\src\\test\\recources");
    }

    private int sum(String fileName) {
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine;
            sCurrentLine = br.readLine();
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
