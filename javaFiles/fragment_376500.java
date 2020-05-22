class Person {

     private List<String> data = new ArrayList<>();

     public void clearDate () {
         data.clear();
     }

     public void addToDate (String s) {
         data.add(s);
     }

     public List<String> getData () {
         return data.clone();
     }
}

Class Test {

     public static void main(String args[]) {

         Person person = new Person();

         //next two lines safely clears and adds values in the Person class private property
         person.clearData();
         person.addToData("test");
     }
}