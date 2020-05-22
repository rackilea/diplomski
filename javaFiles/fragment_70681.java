class Test
{
    public static int counter = 1;
    private int id;
    private int age;
    private String name;

    public Test(String name, int age)
    {
        this.id = counter;
        this.age = age;
        this.name = name;
        counter++;
    }

    public String toString()
    {
        return id + " " + name + "," + age;
    }
....