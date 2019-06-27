package com.mycompany.app;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest  {

    @Test
    public void writeToFileTest() {
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

    @Test
    public void sumTest(){
        App appTest = new App();
        int sum = appTest.sum("resources\\numbers.txt");
        assertEquals(55, sum);
    }

    @Test
    public void sortTest(){
        List<String> expected = new ArrayList<>();
        String unsortedName = "src/test/resources/sorted.txt";
        String sortedName = "target/testSorted.txt";

        App appTest = new App();
        appTest.sort(unsortedName,sortedName);

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/sorted.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                expected.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> sorted = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sortedName)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                sorted.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, sorted);
    }
}
