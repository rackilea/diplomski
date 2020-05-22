package com.web;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilePollingThread implements Runnable {

    private String filepath = null;
    private boolean polling = false;
    private StringBuffer dataWritenAfterLastPoll = null;
    private String error = null;

    public FilePollingThread(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
            dataWritenAfterLastPoll = new StringBuffer();
            polling = true;

            String line = null;

            while(polling) {
                try {
                    line = br.readLine();
                    while(line == null) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            error = e.toString();
                        }
                        line = br.readLine();
                    }
                    dataWritenAfterLastPoll.append(markUp(line));
                } catch (IOException e) {
                    e.printStackTrace();
                    error = e.toString();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            error = e.toString();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    error = e.toString();
                }
            }
        }
    }

    private String markUp(String line) {
        String markup = "";
        if(line != null) {
            markup = "<div style=\"height: 6px\"><span style=\"line-height: 1.1;\">" + line + "</span></div>\n";
        }
        return markup;
    }

    public synchronized void stopPolling() {
        polling = false;
    }

    public synchronized String poll() {
        String tmp = markUp(error == null ? "Not ready" : error);
        if(dataWritenAfterLastPoll != null) {
            tmp = dataWritenAfterLastPoll.toString();
            dataWritenAfterLastPoll = new StringBuffer();
        }
        return tmp;
    }
}