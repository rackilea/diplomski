Object object = null;
try {
    object = jsonParser.parse(new FileReader(file));//exception happens here.
} catch (Exception e) {
   e.printStackTrace(); 
   continue;   // go to the top of the for loop
}