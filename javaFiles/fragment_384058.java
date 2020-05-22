import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindR {

public static void main(String[] args)
{
    ArrayList<Employee> l = new ArrayList();
    l.add(new FindR().new Employee("A",21,"comp_A",100.0));
    l.add(new FindR().new Employee("A",21,"comp_A",100.0));
    l.add(new FindR().new Employee("A",21,"comp_A",null));
    l.add(new FindR().new Employee("A",21,"comp_A",null));
    l.add(new FindR().new Employee("B",22,"comp_B",null));
    l.add(new FindR().new Employee("B",22,"comp_B",200.0));
    l.add(new FindR().new Employee("C",23,"comp_C",300.0));
    l.add(new FindR().new Employee("D",24,"comp_D",null));
    l.add(new FindR().new Employee("E",25,"comp_E",null));

    List<Employee> l_salaryNotNull = l.stream().filter(p->p.salary !=null).collect(Collectors.toList());
    System.out.println("_salalary defined_");
    l_salaryNotNull.stream().forEach(System.out::println);

    System.out.println("_unique by name,age,company_");
    List<String> l_uByNAC = l.stream().map(p->p.name+":"+p.age+":"+p.company).distinct().collect(Collectors.toList());

    //or remove first null values and then get keys
    //List<String> l_uByNAC = l.stream().filter(p->p.salary !=null).map(p->p.name+":"+p.age+":"+p.company).distinct().collect(Collectors.toList());

    l_uByNAC.stream().forEach(System.out::println);
    //eg: process first record 
    String aux[] = l_uByNAC.get(0).split(":");
    System.out.println("keys for search in initial list | name="+aux[0]+",age="+aux[1]+",company="+aux[2]);
}


public class Employee 
{
    public String name;
    public Integer age;
    public String company;
    public Double salary;
    public Employee(String n, Integer a,String c, Double s)
    {
        name = n;
        age = a;
        company = c;
        salary = s;
    }

    public String toString()
    {
        return "name:"+name+":age:"+age+":company:"+company+":salary:"+salary;
    }
}
}
//output
//_salalary defined_
//name:A:age:21:company:comp_A:salary:100.0
//name:A:age:21:company:comp_A:salary:100.0
//name:B:age:22:company:comp_B:salary:200.0
//name:C:age:23:company:comp_C:salary:300.0
//_unique by name,age,company_
//A:21:comp_A
//B:22:comp_B
//C:23:comp_C
//D:24:comp_D
//E:25:comp_E
//(first)key for search in initial list | name=A,age=21,company=comp_A