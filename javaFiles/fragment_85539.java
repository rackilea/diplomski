public class Vehicle{
    int rollNo;
    String name;
    int age;

    // Note no constructor, so the default no-arg constructor can be used. 

    // Now the setters
    public void setRollNo(int anInt) {
        this.rollNo = anInt;
    }

    public String setName(String aName) {
        this.name = aName;
    }

    public void setAge(int anAge) {
        this.age = anAge;
    }

    public static void main(String[] args){
        Vehicle v=new Vehicle(); // note no-arg constructor being used.
        v.setRollNo(3);
        v.setName("Hello");
        v.setAge(12);
        System.out.println(v);
    }

}