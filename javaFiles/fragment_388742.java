private static int counter = 0;
public Die()
{
    counter++;
    // Other stuffs
}
// Have a getter method for the counter so that you can 
// get the count of instances created at any point of time
public static int getCounter() {
    return counter;
}