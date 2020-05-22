import java.util.*;

public class Test {

    private final String name;

    public Test(String name)
    {
        this.name = name;
    }

    public static void main(String[] args)
    {
        Map<Test, String> firstMap = new HashMap<Test, String>();

        Test a = new Test("a");
        Test b = new Test("b");

        firstMap.put(b, "b");
        firstMap.put(a, "a");

        Map<Test, String> secondMap = new HashMap<Test, String>();
        for (Map.Entry<Test, String> entry : firstMap.entrySet())
        {
            System.out.println("Adding " + entry.getKey().name);
            secondMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(secondMap.size());
    }

    @Override public int hashCode()
    {
        return 0;
    }

    @Override public boolean equals(Object other)
    {
        return this.name.equals("b");
    }
}