private static void printToTxt(){

String info = "Collected Informations";
String idForTxtFile = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
File file = new File("Filename" + idForTxtFile);

try {
  FileWriter fw = new FileWriter(file, true);

  //if you want to write the linesperator ("\n) as they are in the txt you should use the following Code:

  String lineSeparator = System.getProperty("line.separator");
  String[] ouput = info.split("\n");

  for (int i = 0; i <= output.length-1; i++) {
    fw.write(output[i]);
    fw.write(lineSeparator);
  }

  //instead you could only use:
  fw.write(info);

  fw.flush();
  fw.close();
} catch (IOException e) {
  e.printStackTrace();
  System.out.println(e.getLocalizedMessage);
}