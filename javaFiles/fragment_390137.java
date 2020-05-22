for (i = 2; i < 7; i++)
{
    System.out.println("hello");
    if (rs.getInt(i) < min) { // getInt()
        index = i;
        min = rs.getInt(i); // second getInt() call for same index --- throws exception
    }
}