package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
//        args[0] = "("
        String docFilePath = "/Users/mikhail/Downloads/JAVA_Documentation_source.txt";
        Path docPath = FileSystems.getDefault().getPath(docFilePath);
        if (!Files.exists(docPath)) {
            throw new IOException();
        }
        int character = (int) args[0].charAt(0);
        int counter = 0;
        BufferedReader br = Files.newBufferedReader(docPath);
        int i = 0;
        while ((i = br.read()) >= 0) {
            if (i == character) {
                counter++;
            }
        }
        System.out.println("Number of \"" + args[0].charAt(0) + "\" character is: " + counter);
        /* OUTPUT:

        Number of "(" character is: 21

         */
    }

}
