public class Employee implements java.io.Serializable
{
 public String name;
 public transient Integer id;
}
System.out.println("Name: " + e.name); will give the o/p REUBEN
System.out.println("ID: " + e.id); will give the o/p null