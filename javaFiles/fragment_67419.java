public class Java8 {
public static void main(String[] args) {
    List<Student> myList = new ArrayList<Student>();
    myList.add(new Student(1, "John", "John is a good Student"));
    myList.add(new Student(1, "Paul", "Paul is a good Player"));
    myList.add(new Student(1, "Tom", "Paul is a good Teacher"));

    System.out.println(myList);//old list
    myList = myList.stream().peek(obj -> obj.setBiography(null)).collect(Collectors.toList());
    System.out.println(myList);//new list
}

/*Output*/
//[Student [id=1, Name=John, biography=John is a good Student], Student [id=1, Name=Paul, biography=Paul is a good Player], Student [id=1, Name=Tom, biography=Paul is a good Teacher]]
//[Student [id=1, Name=John, biography=null], Student [id=1, Name=Paul, biography=null], Student [id=1, Name=Tom, biography=null]]