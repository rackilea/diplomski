@Named(value = "student")
@SessionScoped
public class StudentBean {

 private ArrayList<Student> studentList = new ArrayList<>();

     private String name;
     private int age;

     public StudentBean(String name, int age) {
        this.name = name;
        this.age = age;
     }


      public StudentBean() {
      }

      public String showGo(){
         Stundent student = new Student(name, age);
         studentList.add(student);

         return "show";
     }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStundentList() {
        return studentList;
    }
}