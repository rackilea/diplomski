class Person {
   final String name;
   final String birth; // maybe make this a Date?
   final String gender; // if you subscribe to the gender binary, maybe make this an enum?
   Person(String name, String birth, String gender) { // constructor
     this.name = name;
     this.birth = birth;
     this.gender = gender;
   }
}