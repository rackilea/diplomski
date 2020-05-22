public class CheckThingy
{
    public static final void main(String[] params)
    {
        String name;
        Class  c;

        if (params.length < 1)
        {
            System.out.println("Please give a class/interface name");
            System.exit(1);
        }
        name = params[0];
        try
        {
            c = Class.forName(name);
            System.out.println(name + " is " + (c.isInterface() ? "an interface." : "a class."));
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(name + " not found in the classpath.");
        }
        System.exit(0);
    }
}