try {
   FileWriter writer = new FileWriter("Appointments" + name + "1.txt", true);
   FileReader reader = new FileReader("Appointments" + name + ".txt");
   BufferedReader bufferedReader= new BufferedReader(reader);
   BufferedWriter bufferedWriter = new BufferedWriter(writer);
   .......
} catch () {
   ......
} finally {
   bufferedReader.close();
   bufferedWriter.flush();
   bufferedWriter.close();
}

// Rename the file and delete temp file
File srcFile = new File("Appointments" + name + "1.txt");
File targerFile = new File("Appointments" + name + ".txt");
srcFile.renameTo(targetFile);
srcFile.delete();