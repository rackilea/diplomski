import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;

public class DownloadFile {

 private FTPClient client = new FTPClient();

 public void connect() throws SocketException, IOException {
  client.connect("127.0.0.1");
  client.login("user", "password");
 }

 public boolean hasXCRCSupport() throws IOException {
  client.sendCommand("feat");
  String response = client.getReplyString();
  Scanner scanner = new Scanner(response);
  while(scanner.hasNextLine()) {
   String line = scanner.nextLine();
   if(line.contains("XCRC")) {
    return true;
   }
  }
  return false;
 }

 public boolean isSameFile() throws IOException {
  if(hasXCRCSupport()) {
   File file = new File("D:/test.txt");
   String localCRC = Integer.toHexString((int) FileUtils.checksumCRC32(file)).toUpperCase();
   client.sendCommand("XCRC /test.txt");
   String response = client.getReplyString().trim();
   System.out.println(response);
   if(response.endsWith(localCRC)) {
    return true;
   }
  }
  return false;
 }
 public void logout() throws IOException {
  client.logout();
 }

 public static void main(String[] args) throws SocketException, IOException {
  DownloadFile downloadFile = new DownloadFile();
  downloadFile.connect();
  if(downloadFile.isSameFile()) {
   System.out.println("remote file is same as local");
  }
  downloadFile.logout();
 }
}