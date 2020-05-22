import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NestedNullCheckTest
{
    public static void main(String[] args)
    {
        for (int i=0; i<1000; i++)
        {
            runTest();
        }
    }

    private static void runTest()
    {
        List<DummyString> list = createList();
        int blackHole = 0;
        for (DummyString string : list)
        {
            blackHole += processStringTest(string);
        }
        System.out.println("Result "+blackHole);
    }


    private static int processStringTest(DummyString string)
    {
        if (string == null)
        {
            return -1;
        }
        return NestedNullCheckA.processStringA(string);
    }


    private static List<DummyString> createList()
    {
        List<DummyString> list = new ArrayList<DummyString>();
        Random random = new Random(0);

        for (int i=0; i<100000; i++)
        {
            if (random.nextDouble() < 0.1)
            {
                list.add(null);
            }
            else
            {
                list.add(new DummyString(i));
            }
        }
        return list;
    }
}

class DummyString
{
    int value;
    DummyString(int value)
    {
        this.value = value;
    }
}

class NestedNullCheckA
{
    public static int processStringA(DummyString string)
    {
        if (string == null)
        {
            return -2;
        }
        string.value += 1;
        return NestedNullCheckB.processStringB(string);
    }
}


class NestedNullCheckB
{
    public static int processStringB(DummyString string)
    {
        if (string == null)
        {
            return -3;
        }
        string.value -= 2;
        return NestedNullCheckC.processStringC(string);
    }
}


class NestedNullCheckC
{
    public static int processStringC(DummyString string)
    {
        if (string == null)
        {
            return -4;
        }
        string.value *= 2;
        return string.value;
    }
}