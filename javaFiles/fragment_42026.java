import java.util.*;

class Test implements Comparable<Test>
{
    private int x;

    Test(int input)
    { 
        x = input;
    }

    public static void main(String args[])
    {
        List<Test> list = new ArrayList<Test>();
        list.add(new Test(2));
        list.add(new Test(2));
        Collections.sort(list);
    }

    public int compareTo(Test other)
    {
      return x - other.x;
    }
}