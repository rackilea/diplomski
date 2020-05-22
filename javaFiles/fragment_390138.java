for (i = 2; i < 7; i++)
{
    System.out.println("hello");
    int value=rs.getInt(i); // getInt() call, put into local variable
    if (value < min) {
        index = i;
        min = value; //just use local variable - OK
    }
}