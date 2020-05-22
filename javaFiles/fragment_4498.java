public static final class Student
{
    final String name;
    final int regNo;

    public Student(String name, int regNo) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("BEFORE ASSIGNMENT:");
        System.out.println(getName());
        System.out.println(getRegNo());

        this.name = name;
        this.regNo = regNo;

        System.out.println("AFTER ASSIGNMENT:");
        System.out.println(getName());
        System.out.println(getRegNo());
    }
    public String getName()
    {
        return name;
    }
    public int getRegNo()
    {
        return regNo;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        new Student("Rahul", 3);
    }
}