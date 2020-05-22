File csvFile = new File(csvName);
try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));){
  for(String item : list){
    csvWriter.println(item);
  }
} catch (IOException e) {
    //Handle exception
    e.printStackTrace();
}