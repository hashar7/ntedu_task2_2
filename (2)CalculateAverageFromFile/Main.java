package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static int getRandomInt() {
        return (int) (Math.random() * (Byte.MAX_VALUE));
    }

    public static void main(String[] args) throws IOException {
        // Create a file
        String filePath = "/Users/mikhail/Downloads/Numbers";
        Path path = FileSystems.getDefault().getPath(filePath);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        Files.createFile(path);

        // Write integer numbers to the file
        StringBuffer sb = new StringBuffer();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            sb.append(getRandomInt()).append(i != 100 ? i % 10 == 0 ? "\n" : " " : "");
        });
        Files.writeString(path, sb.toString());

        // Read byte, integer and float values from the file
        List<String> lines = Files.readAllLines(Paths.get(Objects.requireNonNull(filePath)), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
        System.out.println();
        BufferedReader br = Files.newBufferedReader(path);
        String res = br.readLine();
        ArrayList<Integer> intNumbers = new ArrayList<>();
        ArrayList<Byte> byteNumbers = new ArrayList<>();
        ArrayList<Float> floatNumbers = new ArrayList<>();
        while (res != null) {
            String[] nums = res.split("\s");
            Arrays.stream(nums).forEach(s -> {
                intNumbers.add(Integer.parseInt(s));
                byteNumbers.add(Byte.parseByte(s));
                floatNumbers.add(Float.parseFloat(s));
            });
            res = br.readLine();
        }

        // Print arrays of values
        System.out.println("Integer array:" + Arrays.toString(intNumbers.toArray()));
        System.out.println("Byte array:" + Arrays.toString(byteNumbers.toArray()));
        System.out.println("Float array:" + Arrays.toString(floatNumbers.toArray()));
        System.out.println();

        // Calculate average of second half of the integer array
        int intBound = intNumbers.size();
        Double intSum = 0D;
        int intCount = 0;
        for(int i = intBound / 2; i < intBound; i++, intCount++) {
            intSum += intNumbers.get(i);
        }
        double intAverageOfSecondHalf = intSum / intCount;
        System.out.println("intAverage of second half of the array: " + intAverageOfSecondHalf);
        // Calculate average of third quarter of the integer array
        intSum = 0.0;
        intCount = 0;
        int newIntBound = intBound / 4 * 3;
        for(int i = intBound / 2; i < newIntBound; i++, intCount++) {
            intSum += intNumbers.get(i);
        }
        double intAverageOfThirdQuarter = intSum / intCount;
        System.out.println("intAverage of third quarter of the array: " + intAverageOfThirdQuarter + "\n");

        // Calculate average of second half of the byte array
        int byteBound = byteNumbers.size();
        Double byteSum = 0D;
        int byteCount = 0;
        for(int i = byteBound / 2; i < byteBound; i++, byteCount++) {
            byteSum += byteNumbers.get(i);
        }
        double byteAverageOfSecondHalf = byteSum / byteCount;
        System.out.println("byteAverage of second half of the array: " + byteAverageOfSecondHalf);
        // Calculate average of third quarter of the byte array
        byteSum = 0.0;
        byteCount = 0;
        int newByteBound = byteBound / 4 * 3;
        for(int i = byteBound / 2; i < newByteBound; i++, byteCount++) {
            byteSum += byteNumbers.get(i);
        }
        double byteAverageOfThirdQuarter = byteSum / byteCount;
        System.out.println("byteAverage of third quarter of the array: " + byteAverageOfThirdQuarter + "\n");

        // Calculate average of second half of the float array
        int floatBound = floatNumbers.size();
        Double floatSum = 0D;
        int floatCount = 0;
        for(int i = floatBound / 2; i < floatBound; i++, floatCount++) {
            floatSum += floatNumbers.get(i);
        }
        double floatAverageOfSecondHalf = floatSum / floatCount;
        System.out.println("floatAverage of second half of the array: " + floatAverageOfSecondHalf);
        // Calculate average of third quarter of the float array
        floatSum = 0.0;
        floatCount = 0;
        int newFloatBound = floatBound / 4 * 3;
        for(int i = floatBound / 2; i < newFloatBound; i++, floatCount++) {
            floatSum += floatNumbers.get(i);
        }
        double floatAverageOfThirdQuarter = floatSum / floatCount;
        System.out.println("floatAverage of third quarter of the array: " + floatAverageOfThirdQuarter + "\n");
    }

    /* OUTPUT:

    101 113 61 115 1 33 119 13 80 6
    65 37 98 57 120 117 28 81 10 56
    109 46 56 52 14 124 14 20 88 98
    82 74 115 73 121 23 11 78 33 89
    59 94 81 88 61 13 119 58 31 45
    4 3 49 21 125 87 84 120 121 43
    8 45 13 53 45 75 31 21 65 107
    70 65 89 27 0 12 13 34 122 2
    3 22 93 3 73 50 86 2 38 56
    8 102 22 3 57 92 42 68 31 11

    Integer array:[101, 113, 61, 115, 1, 33, 119, 13, 80, 6, 65, 37, 98, 57, 120, 117, 28, 81, 10, 56, 109, 46, 56, 52, 14, 124, 14, 20, 88, 98, 82, 74, 115, 73, 121, 23, 11, 78, 33, 89, 59, 94, 81, 88, 61, 13, 119, 58, 31, 45, 4, 3, 49, 21, 125, 87, 84, 120, 121, 43, 8, 45, 13, 53, 45, 75, 31, 21, 65, 107, 70, 65, 89, 27, 0, 12, 13, 34, 122, 2, 3, 22, 93, 3, 73, 50, 86, 2, 38, 56, 8, 102, 22, 3, 57, 92, 42, 68, 31, 11]
    Byte array:[101, 113, 61, 115, 1, 33, 119, 13, 80, 6, 65, 37, 98, 57, 120, 117, 28, 81, 10, 56, 109, 46, 56, 52, 14, 124, 14, 20, 88, 98, 82, 74, 115, 73, 121, 23, 11, 78, 33, 89, 59, 94, 81, 88, 61, 13, 119, 58, 31, 45, 4, 3, 49, 21, 125, 87, 84, 120, 121, 43, 8, 45, 13, 53, 45, 75, 31, 21, 65, 107, 70, 65, 89, 27, 0, 12, 13, 34, 122, 2, 3, 22, 93, 3, 73, 50, 86, 2, 38, 56, 8, 102, 22, 3, 57, 92, 42, 68, 31, 11]
    Float array:[101.0, 113.0, 61.0, 115.0, 1.0, 33.0, 119.0, 13.0, 80.0, 6.0, 65.0, 37.0, 98.0, 57.0, 120.0, 117.0, 28.0, 81.0, 10.0, 56.0, 109.0, 46.0, 56.0, 52.0, 14.0, 124.0, 14.0, 20.0, 88.0, 98.0, 82.0, 74.0, 115.0, 73.0, 121.0, 23.0, 11.0, 78.0, 33.0, 89.0, 59.0, 94.0, 81.0, 88.0, 61.0, 13.0, 119.0, 58.0, 31.0, 45.0, 4.0, 3.0, 49.0, 21.0, 125.0, 87.0, 84.0, 120.0, 121.0, 43.0, 8.0, 45.0, 13.0, 53.0, 45.0, 75.0, 31.0, 21.0, 65.0, 107.0, 70.0, 65.0, 89.0, 27.0, 0.0, 12.0, 13.0, 34.0, 122.0, 2.0, 3.0, 22.0, 93.0, 3.0, 73.0, 50.0, 86.0, 2.0, 38.0, 56.0, 8.0, 102.0, 22.0, 3.0, 57.0, 92.0, 42.0, 68.0, 31.0, 11.0]

    intAverage of second half of the array: 48.32
    intAverage of third quarter of the array: 54.84

    byteAverage of second half of the array: 48.32
    byteAverage of third quarter of the array: 54.84

    floatAverage of second half of the array: 48.32
    floatAverage of third quarter of the array: 54.84

     */

}
