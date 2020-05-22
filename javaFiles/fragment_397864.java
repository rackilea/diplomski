class MyClass {
   public static void main(String[] args) {
      MyClass obj = new MyClass();
      obj.loadProperties(line);    
   }

   private void loadProperties(String line) {
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("foo.properties");
        ...  
   }
}