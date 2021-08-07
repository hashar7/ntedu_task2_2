package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String newFilePath = "/Users/mikhail/Downloads/JavaDocumentation";
        String docFilePath = "/Users/mikhail/Downloads/JAVA_Documentation_source.txt";
        Path filePath = FileSystems.getDefault().getPath(newFilePath);
        Path docPath = FileSystems.getDefault().getPath(docFilePath);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }
        Files.createFile(filePath);
        if (!Files.exists(FileSystems.getDefault().getPath(docFilePath))) {
            throw new IOException();
        }
        BufferedReader br = Files.newBufferedReader(docPath);
        Pattern pattern = Pattern.compile("\\s+java\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        int javaWordCounter = 0;
        int endLineIndex = -1;
        String line = br.readLine();
        while (line != null) {
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                javaWordCounter++;
                if (javaWordCounter == 3) {
                    endLineIndex = matcher.end();
                    break;
                }
            }
            if (endLineIndex != -1) {
                line = line.substring(0, endLineIndex);
                Files.writeString(filePath, line + "\n", StandardOpenOption.APPEND);
                break;
            } else {
                Files.writeString(filePath, line + "\n", StandardOpenOption.APPEND);
                line = br.readLine();
            }
        }
    }

}
