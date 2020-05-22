import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.*;


    public class ParseText {
static LinkedList<Employee> list = new LinkedList<>();

public static void main(String[] args) throws Exception{
    readFile();
    getEmployee("A11-11"); //This is for test, you get the
                            //read the id from command line as well

     }
public static void readFile() throws FileNotFoundException {
    File file=new File("C:\\test\\textTest.txt");
    Scanner sc = new Scanner(file);    
    String temp;
    while(sc.hasNext()){
        temp = sc.nextLine();
        //System.out.println("temp "+ temp);
        String[] s = temp.split(" ");
        String[] name = s[1].split(",");
        String id = s[0];
        String lastName = name[0];
        String firstName = name[1];
        Employee emp = new Employee(firstName, lastName, id);
        list.add(emp);
    }
    sc.close();
     }

public static void getEmployee(String id) {
    Iterator<Employee> itr = list.iterator();
    while(itr.hasNext()) {
        Employee emp = itr.next();
        if(emp.id.equals(id)){
            System.out.println("Employee Name:- "+emp.firtName+" "+emp.lastName);
        }
    }
}
    }

    class Employee {
String firtName;
String lastName;
String id;

Employee(String firstName, String lastName, String id) {
    this.firtName = firstName;
    this.lastName = lastName;
    this.id = id;
}

public String getFirtName() {
    return firtName;
}

public String getLastName() {
    return lastName;
}

public String getId() {
    return id;
}
    }