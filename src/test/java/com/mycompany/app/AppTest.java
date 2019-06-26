package com.mycompany.app;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest  {

    @Test
    public void myTest() {
        List<String> expected = new ArrayList<>();
        expected.add("string1");
        expected.add("string2");
        expected.add("string3");

        App app = new App();
        app.writeToFile(expected);

        List<String> test = new ArrayList<>();
        // читаем файл построчно в test
        try (BufferedReader br = new BufferedReader(new FileReader("target/output.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                test.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // сравниваем два списка

        assertEquals(expected,test);
    }
}
