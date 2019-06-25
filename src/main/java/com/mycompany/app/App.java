package com.mycompany.app;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public App() {
    }

    public static void main(String[] args ) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("string1");
        strings.add("string2");
        strings.add("string3");
        FileWriter writer = new FileWriter("output.txt");
        for(String str: strings) {
            writer.write(str);
        }
        writer.close();
    }

}
