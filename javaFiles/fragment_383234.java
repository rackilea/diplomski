BufferedReader br = new BufferedReader(new FileReader(file));
String line;
int num = 0;
NumberTranslator myAwesomeTranslator = new NumberTranslator();
while ((line = br.readLine()) != null) {
   try {
      num = Integer.parseInt(line);
      System.out.println(myAwesomeTranslator.translate(num));
   } catch (NumberFormatException e) {
      System.out.println("I thought you were an int :(");
   }
}
br.close();