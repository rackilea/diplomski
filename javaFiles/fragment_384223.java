public class Tree
{
    public Tree(int age, double height)
    {
        this.age = age;
        this.height = height;
    }
}

public class Ash extends Tree
{
    public Ash(int age, double height)
    {
        super(age, height);
    }
}