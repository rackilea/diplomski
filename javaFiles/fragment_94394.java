package com.mbc.receiptprinter.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;

import com.mbc.receiptprinter.constant.FileDelimiters;
import com.mbc.receiptprinter.constant.FilePaths;

/*
 * Various File utility functions.  This class uses the Apache Commons FileUtils class.
 */
public class ReceiptPrinterFileUtils {

    private static Map<String, String> fileContents = new HashMap<String, String>();

    private static Map<String, Boolean> fileHasBeenUpdated = new HashMap<String, Boolean>();

    static {
        for (FilePaths fp : FilePaths.values()) {
            File f = new File(fp.getPath());
            try {
                FileUtils.touch(f);
                fileHasBeenUpdated.put(fp.getPath(), false);
                fileContents.put(fp.getPath(), FileUtils.readFileToString(f));
            } catch (IOException e) {
                ReceiptPrinterLogger.logMessage(ReceiptPrinterFileUtils.class, 
                                                Level.SEVERE, 
                                                "IOException while performing FileUtils.touch in static block of ReceiptPrinterFileUtils", e);
            }
        }
    }

    public static String getFileContents(String filePath) throws IOException {
        if (ReceiptPrinterStringUtils.isNullOrEmpty(filePath)) throw new IllegalArgumentException("File path must not be null or empty");
        File f = new File(filePath);
        if (fileHasBeenUpdated.get(filePath)) {
            fileContents.put(filePath, FileUtils.readFileToString(f));
            fileHasBeenUpdated.put(filePath, false);
        }
        return fileContents.get(filePath);
    }

    public static List<String> convertFileContentsToList(String fileContents) {
        List<String> records = new ArrayList<String>();
        if (fileContents.contains(FileDelimiters.RECORD)) {
            records = Arrays.asList(fileContents.split(FileDelimiters.RECORD));
        }
        return records;
    }

    public static void writeStringToFile(String filePath, String data) throws IOException {
        fileHasBeenUpdated.put(filePath, true);
        FileUtils.writeStringToFile(new File(filePath), data);
    }

    public static void writeStringToFile(String filePath, String data, boolean append) throws IOException {
        fileHasBeenUpdated.put(filePath, true);
        FileUtils.writeStringToFile(new File(filePath), data, append);
    }
}