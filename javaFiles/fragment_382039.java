import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class TableStringTest
{
    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<Person>();
        for (int i=0; i<10; i++)
        {
            persons.add(new Person());
        }

        TableStringBuilder<Person> t = new TableStringBuilder<Person>();
        t.addColumn("id", Person::getId);
        t.addColumn("first name", Person::getFirstName);
        t.addColumn("last name", Person::getLastName);
        t.addColumn("height", Person::getHeight);

        String s = t.createString(persons);
        System.out.println(s);
    }
}


class TableStringBuilder<T>
{
    private final List<String> columnNames;
    private final List<Function<? super T, String>> stringFunctions;

    TableStringBuilder()
    {
        columnNames = new ArrayList<String>();
        stringFunctions = new ArrayList<Function<? super T, String>>();
    }

    void addColumn(String columnName, Function<? super T, ?> fieldFunction)
    {
        columnNames.add(columnName);
        stringFunctions.add((p) -> (String.valueOf(fieldFunction.apply(p))));
    }

    private int computeMaxWidth(int column, Iterable<? extends T> elements)
    {
        int n = columnNames.get(column).length();
        Function<? super T, String> f = stringFunctions.get(column);
        for (T element : elements)
        {
            String s = f.apply(element);
            n = Math.max(n, s.length());
        }
        return n;
    }

    private static String padLeft(String s, char c, int length)
    {
        while (s.length() < length)
        {
            s = c + s;
        }
        return s;
    }

    private List<Integer> computeColumnWidths(Iterable<? extends T> elements)
    {
        List<Integer> columnWidths = new ArrayList<Integer>();
        for (int c=0; c<columnNames.size(); c++)
        {
            int maxWidth = computeMaxWidth(c, elements);
            columnWidths.add(maxWidth);
        }
        return columnWidths;
    }

    public String createString(Iterable<? extends T> elements)
    {
        List<Integer> columnWidths = computeColumnWidths(elements);

        StringBuilder sb = new StringBuilder();
        for (int c=0; c<columnNames.size(); c++)
        {
            if (c > 0)
            {
                sb.append("|");
            }
            String format = "%"+columnWidths.get(c)+"s";
            sb.append(String.format(format, columnNames.get(c)));
        }
        sb.append("\n");
        for (int c=0; c<columnNames.size(); c++)
        {
            if (c > 0)
            {
                sb.append("+");
            }
            sb.append(padLeft("", '-', columnWidths.get(c)));
        }
        sb.append("\n");

        for (T element : elements)
        {
            for (int c=0; c<columnNames.size(); c++)
            {
                if (c > 0)
                {
                    sb.append("|");
                }
                String format = "%"+columnWidths.get(c)+"s";
                Function<? super T, String> f = stringFunctions.get(c);
                String s = f.apply(element);
                sb.append(String.format(format, s));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


//Dummy Person Class
class Person
{
    private int id;
    private String firstName;
    private String lastName;
    private float height;

    private static Random random = new Random(0);

    Person()
    {
        id = random.nextInt(100000);
        firstName = createRandomString();
        lastName = createRandomString();
        height = (150 + random.nextInt(40)) / 100.0f;
    }

    private static String createRandomString()
    {
        int length = random.nextInt(10) + 5;
        StringBuilder sb = new StringBuilder();
        char offset = 'A';
        for (int i=0; i<length; i++)
        {
            char c = (char)(random.nextInt(26) + offset);
            sb.append(c);
            offset = 'a';
        }
        return sb.toString();
    }

    int getId()
    {
        return id;
    }

    String getFirstName()
    {
        return firstName;
    }

    String getLastName()
    {
        return lastName;
    }

    float getHeight()
    {
        return height;
    }
}