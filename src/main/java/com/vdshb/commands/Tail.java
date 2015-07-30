package com.vdshb.commands;

import com.vdshb.CurrentPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.out;

public class Tail {

    public static void tail(String[] args) {
        if (args.length < 1) {
            out.println("Incorrect command parameters.");
            return;
        }
        int tailLinesNumber;
        if (args.length > 1) {
            tailLinesNumber = Integer.valueOf(args[1]);
        } else {
            tailLinesNumber = 10;
        }
        Path filePath = CurrentPath.getRelatedPath(args[0]);
        tail(filePath, tailLinesNumber);
    }

    private static void tail(Path fileToRead, int tailLinesNumber) {

        try (BufferedReader reader = Files.newBufferedReader(fileToRead, StandardCharsets.UTF_8)) {
            String line = null;
            while ((line = reader.readLine()) != null)
                out.println(line);
        } catch (IOException e) {
            out.println("Can not read file");
        }
    }
}
