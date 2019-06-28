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
public class AppTest {

    @Test
    public void writeToFileTest() {
        List<String> expected = new ArrayList<>();
        expected.add("string1");
        expected.add("string2");
        expected.add("string3");

        App app = new App();
        app.writeToFile(expected);

        // читаем файл построчно в test
        List<String> test = readList("target/output.txt");

        // сравниваем два списка

        assertEquals(expected, test);
    }

    @Test
    public void sumTest() {
        App appTest = new App();
        int sum = appTest.sum("src/test/resources\\numbers.txt");
        assertEquals(55, sum);
    }

    @Test
    public void sortTest() {
        String unsortedName = "src/test/resources/unsorted.txt";
        String sortedName = "target/testSorted.txt";
        String etalonName = "src/test/resources/sorted.txt";

        App appTest = new App();
        appTest.sort(unsortedName, sortedName);

        List<String> expected = readList(etalonName);

        List<String> sorted = readList(sortedName);
        assertEquals(expected, sorted);
    }

    @Test
    public void dateSort() throws IOException {
        String unsortedName = "src/test/resources/dates.txt";
        String sortedName = "target/datesSorted.txt";
        String etalonName = "src/test/resources/etalon.txt";

        App appTest = new App();
        appTest.dateSort(unsortedName, sortedName);
        List<String> expected = readList(etalonName);

        List<String> sorted = readList(sortedName);
        assertEquals(expected, sorted);
    }

    private List<String> readList(String fileName) {
        List<String> expected = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                expected.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expected;
    }
}
