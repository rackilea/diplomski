Person = new Person(name, ssn, birthday);
int studentId = 1297;
TreeMap<Integer,Person> student = new TreeMap<>();
student.put(studentId, Person);
String className = "classOf2018";
TreeMap<String, TreeMap<Integer,Person>> class2018 = new TreeMap<>();   
class2018.put(className, student);