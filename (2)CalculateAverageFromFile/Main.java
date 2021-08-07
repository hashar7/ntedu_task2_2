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
        for(int i = intBound / 4 * 3; i < intBound; i++, intCount++) {
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
        for(int i = byteBound / 4 * 3; i < byteBound; i++, byteCount++) {
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
        for(int i = floatBound / 4 * 3; i < floatBound; i++, floatCount++) {
            floatSum += floatNumbers.get(i);
        }
        double floatAverageOfThirdQuarter = floatSum / floatCount;
        System.out.println("floatAverage of third quarter of the array: " + floatAverageOfThirdQuarter + "\n");
    }

    /* OUTPUT:

    112 116 98 55 50 39 114 106 102 40
    11 116 76 12 18 32 56 123 126 86
    42 7 21 15 75 106 85 74 101 88
    1 108 45 52 2 77 59 49 4 85
    60 21 45 113 29 119 48 81 103 64
    107 55 41 20 74 123 64 7 86 32
    2 72 88 65 105 29 58 1 100 13
    47 87 73 32 62 68 51 58 102 17
    83 46 107 91 36 60 61 10 22 92
    41 71 109 78 126 121 5 23 112 82

    Integer array:[112, 116, 98, 55, 50, 39, 114, 106, 102, 40, 11, 116, 76, 12, 18, 32, 56, 123, 126, 86, 42, 7, 21, 15, 75, 106, 85, 74, 101, 88, 1, 108, 45, 52, 2, 77, 59, 49, 4, 85, 60, 21, 45, 113, 29, 119, 48, 81, 103, 64, 107, 55, 41, 20, 74, 123, 64, 7, 86, 32, 2, 72, 88, 65, 105, 29, 58, 1, 100, 13, 47, 87, 73, 32, 62, 68, 51, 58, 102, 17, 83, 46, 107, 91, 36, 60, 61, 10, 22, 92, 41, 71, 109, 78, 126, 121, 5, 23, 112, 82]
    Byte array:[112, 116, 98, 55, 50, 39, 114, 106, 102, 40, 11, 116, 76, 12, 18, 32, 56, 123, 126, 86, 42, 7, 21, 15, 75, 106, 85, 74, 101, 88, 1, 108, 45, 52, 2, 77, 59, 49, 4, 85, 60, 21, 45, 113, 29, 119, 48, 81, 103, 64, 107, 55, 41, 20, 74, 123, 64, 7, 86, 32, 2, 72, 88, 65, 105, 29, 58, 1, 100, 13, 47, 87, 73, 32, 62, 68, 51, 58, 102, 17, 83, 46, 107, 91, 36, 60, 61, 10, 22, 92, 41, 71, 109, 78, 126, 121, 5, 23, 112, 82]
    Float array:[112.0, 116.0, 98.0, 55.0, 50.0, 39.0, 114.0, 106.0, 102.0, 40.0, 11.0, 116.0, 76.0, 12.0, 18.0, 32.0, 56.0, 123.0, 126.0, 86.0, 42.0, 7.0, 21.0, 15.0, 75.0, 106.0, 85.0, 74.0, 101.0, 88.0, 1.0, 108.0, 45.0, 52.0, 2.0, 77.0, 59.0, 49.0, 4.0, 85.0, 60.0, 21.0, 45.0, 113.0, 29.0, 119.0, 48.0, 81.0, 103.0, 64.0, 107.0, 55.0, 41.0, 20.0, 74.0, 123.0, 64.0, 7.0, 86.0, 32.0, 2.0, 72.0, 88.0, 65.0, 105.0, 29.0, 58.0, 1.0, 100.0, 13.0, 47.0, 87.0, 73.0, 32.0, 62.0, 68.0, 51.0, 58.0, 102.0, 17.0, 83.0, 46.0, 107.0, 91.0, 36.0, 60.0, 61.0, 10.0, 22.0, 92.0, 41.0, 71.0, 109.0, 78.0, 126.0, 121.0, 5.0, 23.0, 112.0, 82.0]

    intAverage of second half of the array: 62.3
    intAverage of third quarter of the array: 66.88

    byteAverage of second half of the array: 62.3
    byteAverage of third quarter of the array: 66.88

    floatAverage of second half of the array: 62.3
    floatAverage of third quarter of the array: 66.88

     */

}
