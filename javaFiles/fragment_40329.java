Properties prop = new Properties();

try {
  prop.load(new FileInputStream(removeSpaces(name)+".txt"));
  cust.setAge(Integer.parseInt(prop.getProperty("age")));
} catch (IOException e) {
  e.printStackTrace();
}