public class MainActivity extends Activity
{
    EditText edtFirst, edtMiddle, edtLast, edtDay, edtMonth, edtYear;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edtFirst = (EditText) findViewById(R.id.editText1);
        edtMiddle = (EditText) findViewById(R.id.editText2);
        edtLast = (EditText) findViewById(R.id.editText3);
        edtDay = (EditText) findViewById(R.id.editText7);        
        edtMonth = (EditText) findViewById(R.id.editText8);
        edtYear = (EditText) findViewById(R.id.editText9);
    }

    public void gReport(View v)
    {
        String first = edtFirst.getText().toString();

        if (first.length() == 0)
        {
            Toast.makeText(this, "Please enter a First Name.", Toast.LENGTH_SHORT).show();
            return;
        }

        try
        {
            int day = Integer.parseInt(edtDay.getText().toString());
            int month = Integer.parseInt(edtMonth.getText().toString());
            int year = Integer.parseInt(edtYear.getText().toString());

            int age = getAge(year, month, day);
            int sum17 = getSum17(first, age);

            Intent i = new Intent(this, FullExplanation.class);
            i.putExtra("name17", sum17);
            i.putExtra("age", age);
            startActivity(i);
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(this, "Please enter Day, Month, and Year", Toast.LENGTH_SHORT).show();
        }
        catch (IllegalArgumentException e)
        {           
            Toast.makeText(this, "Invalid Birthdate", Toast.LENGTH_SHORT).show();
        }
    }

    private int getSum17(String name, int age)
    {
        int sum17 = 0;
        int ct = 0;
        boolean done = false;

        char[] name17 = name.toUpperCase().toCharArray();

        if (name17.length == 0 || value17(name17[0]) > age)
        {
            return 0;
        }

        do
        {
            sum17 += value17(name17[ct]);
            ct++;

            if (ct > name.length() - 1)
            {
                ct = 0;
            }

            if (sum17 + value17(name17[ct]) > age)
            {
                done = true;
            }
        }
        while (!done);

        return sum17;       
    }

    private int value17(char c)
    {
        if (c < 65 || c > 90)
        {
            return 0;
        }

        int v = (c - 64) % 9;
        return v == 0 ? 9 : v;      
    }

    public int getAge(int _year, int _month, int _day)
    {
        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a;         

        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH) + 1;
        d = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(_year, _month, _day);
        a = y - cal.get(Calendar.YEAR);
        if ((m < cal.get(Calendar.MONTH) + 1)
            || ((m == cal.get(Calendar.MONTH) + 1) && (d < cal
            .get(Calendar.DAY_OF_MONTH))))
        {
            --a;
        }
        if (a < 0)
            throw new IllegalArgumentException("Age < 0");
        return a;
    }
}