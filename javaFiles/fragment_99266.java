class students
{
    private static int next_id = 0;   // <-- static, class-wide counter

    private int id;                   // <-- per-object ID

    private String name;

    public students(String name)
    {
        this.id = ++students.next_id;
        this.name = name;

        // ...
    }

    public students(students rhs)
    {
        this.id = ++students.next_id;
        this.name = rhs.name;

        // ...
    }

    public static void reset_counter(int n)  // use with care!
    {
        students.next_id = n;
    }

    // ...
}