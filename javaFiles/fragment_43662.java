public static void main(String[] args) throws IOException {
    Schema schema =
         new Schema.Parser().parse(AvroTest.class.getClassLoader().
           getResourceAsStream("pair.avsc"));

     //Collect all field values to an array list
     List<String> fieldValues = new ArrayList<>();
     for(Field field : schema.getFields()) {
            fieldValues.add(field.name());
      }

      //Iterate the arraylist
      for(String value: fieldValues)  {
           System.out.println(value);
      }
  }