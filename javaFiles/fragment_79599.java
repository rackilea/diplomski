// C#, not Java!
public class Test
{
    private int x;

    public class Nested
    {
        public Nested(Test t)
        {
            // Access to outer private variable from nested type
            Console.WriteLine(t.x); 
        }
    }
}