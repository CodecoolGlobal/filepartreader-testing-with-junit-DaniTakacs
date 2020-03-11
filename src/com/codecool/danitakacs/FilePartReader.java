package com.codecool.danitakacs;

import java.io.*;
import java.util.Scanner;

public class FilePartReader {


    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "";
        fromLine = 0;
        toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        File file = new File(filePath);
        Scanner fileToBeRead = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileToBeRead.hasNext()) {
            String line = fileToBeRead.nextLine();
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();

    }

    public String readLines() throws IOException {
        String fileContent = read();
        String[] lines = fileContent.split("\n");
        StringBuilder returnContent = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i + 1 >= fromLine && i + 1 <= toLine) {
                returnContent.append(lines[i]);
                returnContent.append(" ");
            }
        }
        return returnContent.toString().trim();
    }

}
