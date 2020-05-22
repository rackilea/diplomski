public static void meh()
{
    synchronized(getClass()) {
        someOtherCode();
    }
}