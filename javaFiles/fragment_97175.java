ProcessBuilder pb = new ProcessBuilder("C:/Users/Desktop/binary/codegen.exe", "C:/Users/Desktop/binary/Kalimba.mp3");

Process process = pb.start();
BufferedReader stdInput = new BufferedReader(new InputStreamReader(process .getInputStream())); 
FileHandler fh = new FileHandler("D:/log.txt");
Logger logger = Logger.getLogger("global");
logger.addHandler(fh);
SimpleFormatter formatter = new SimpleFormatter();
fh.setFormatter(formatter);
String line = null;
while ((line = stdInput.readLine()) != null) {
    logger.log(Level.INFO, line);
}
System.out.println("Logging Completed...");