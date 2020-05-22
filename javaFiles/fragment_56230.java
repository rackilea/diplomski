package com.grebski.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class FtpTest {

    public static void main(String[] args) throws IOException {
        String ftpUrl = "speedtest.tele2.net";
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ftpUrl);
        ftpClient.user("anonymous");
        ftpClient.pass("anonymous@a.com");
        Arrays.stream(ftpClient.listFiles()).forEach(file -> {
                    LocalDateTime creationDateTime = Instant.ofEpochMilli(file.getTimestamp().getTimeInMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime();
                    String msg = String.format("%s %s", file.getName(), creationDateTime);
                    System.out.println(msg);
                }
        );
    }
}