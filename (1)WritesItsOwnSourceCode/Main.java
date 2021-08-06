package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final String dir = System.getProperty("user.dir");
        String name = Main.class.getName();
        name = name.replace('.', '/') + ".java";
        File file = new File(dir);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not exists!");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory!");
        }
        String filePath = FindSourceCodeFile(dir, name);
        List<String> lines = Files.readAllLines(Paths.get(Objects.requireNonNull(filePath)), StandardCharsets.UTF_8);
        for (String s: lines) {
            System.out.println(s);
        }
    }

    static String FindSourceCodeFile(String szDir, String target) {
        File rootDir = new File(szDir);
        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, Objects.requireNonNull(rootDir.listFiles()));
        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }
        for (String ss : result) {
            if (ss.contains(target)) {
                return ss;
            }
        }
        return null;
    }
}
