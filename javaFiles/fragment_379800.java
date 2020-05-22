BufferedReader reader = null;
try {
  reader = new BufferedReader(new FileReader(file));
  Gson gson = new Gson(); 
  CarInfo[] carInfoArray = gson.fromJson(reader, CarInfo[].class);
} catch (FileNotFoundException ex) {
  ...
} finally {
  ...
}