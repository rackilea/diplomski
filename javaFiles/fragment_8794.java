private String name;
private int age;
private boolean student;
private char gender;    

public Person(String name, int ageParam, boolean studentParam, char genderParam){
    setName(name);
    age = ageParam;
    student = studentParam;
    gender = genderParam;    
}