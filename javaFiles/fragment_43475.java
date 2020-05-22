public static boolean transferTest()
{
    ByteBuffer bb1 = ByteBuffer.allocate(256);
    ByteBuffer bb2 = ByteBuffer.allocate(50);
    for (int i = 0; i < 100; ++i)
    {
        bb1.put((byte)i);
    }
    bb1.flip();
    bb1.position(5);
    ByteBuffer bb1a = bb1.slice();
    bb1a.position(2);
    // bb3 includes the 5-100 range
    bb2.put((byte)77);
    // something to see this works when bb2 isn't empty
    int n = transferAsMuchAsPossible(bb2, bb1a);
    boolean itWorked = (n == 49);

    if (bb1a.position() != 51)
        itWorked = false;
    if (bb2.position() != 50)
        itWorked = false;
    bb2.rewind();
    if (bb2.get() != 77)
        itWorked = false;
    for (int i = 0; i < 49; ++i)
    {
        if (bb2.get() != i+7)
        {
            itWorked = false;
            break;
        }
    }
    return itWorked;
}