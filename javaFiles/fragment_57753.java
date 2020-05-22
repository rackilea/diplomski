public class Bear {
    private String name;
    private String colour;
    private int age;
    private int weight;

    public Bear(String bearName, String bearColour, int bearAge, int bearWeight)
    {
        name = bearName;
        colour = bearColour;
        age = bearAge;
        weight = bearWeight;    
    }

    public static void main(String[] args)
    {
        Bear myBear = new Bear("Jim", "brown", 12, 50); // constructor
        System.out.println("The bear is called" + myBear.getName() +
                              " and is " + myBear.getAge() + " years old!");
    }
}