package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<String> strings = new ArrayList<>();
        strings.add("string1");
        strings.add("string2");
        strings.add("string3");

        App app = new App();
        app.writeToFile(strings);
    }

}
