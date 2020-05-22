public class Template
{
    public static final Template type1 = new Template(1, 2);
    public static final Template type2 = new Template(2, 1);

    public int buttonA;
    public int buttonB;

    public Template(int buttonA, int buttonB)
    {
        this.buttonA = buttonA;
        this.buttonB = buttonB;
    }
}