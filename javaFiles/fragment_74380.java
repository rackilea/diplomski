import java.io.File;
 import java.io.IOException;
 public class ProcessBuilderSample {

 public static void main(String args[]) throws IOException 
 {
  String executable = "ThMapInfratab1-2.exe";
  String argument1  = "TherInput.txt";
  File workingDirectory = new File("C:/Users/Infratab Bangalore/Desktop/Rod");

  ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, argument1);
  pb.directory(workingDirectory);
  pb.start();     
 }
 }