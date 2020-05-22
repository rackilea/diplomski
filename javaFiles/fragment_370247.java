package com.pogs.utilities;

import org.joda.time.DateTime;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that implements request aggregation methods.
 *
 * @author Allan A. Chua
 * @version 1.0
 * @since August 31, 2018
 */
public class RequestAggregator {
    private final static String REQUEST_STORE_PATH = "D:\\logs.txt";

    //region Private Methods
    private void storeToTextFile(String input) {
        try {
            File file = new File(REQUEST_STORE_PATH);
            BufferedWriter fw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));

            fw.write(input);
            fw.newLine();

            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("[" + (new DateTime()).toString() + "][Logger is experiencing troubles]");
        }
    }
    //endregion

    //region Methods

    /**
     * Method used for appending request logs inside
     * the log aggregation method.
     *
     * @param input - Message to be logged.
     */
    public void appendInfo(String input) {
        String log = "[INFO][" + (new DateTime()).toString() + "]";
        log += input;

        storeToTextFile(log);
        System.out.println(log);
    }

    /**
     * Method used for appending error request logs inside
     * the log aggregation method.
     *
     * @param input Message to be logged.
     */
    public void appendError(String input) {
        String log = "[ERROR][" + (new DateTime()).toString() + "]";
        log += input;

        storeToTextFile(log);
        System.out.println(log);
    }
    //endregion
}