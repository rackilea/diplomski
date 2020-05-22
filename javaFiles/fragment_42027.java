import java.util.*;

class TestComparator implements Comparator<Test>
{
   public int compare(Test t1, Test t2)
   {
      return t1.getX() - t2.getX();
   }
}

class Test
{
    private int x;

    Test(int input)
    { 
        x = input;
    }

    int getX()
    {
        return x;
    }

    public static void main(String args[])
    {
        List<Test> list = new ArrayList<Test>();
        list.add(new Test(2));
        list.add(new Test(2));
        Collections.sort(list, new TestComparator());
    }
}