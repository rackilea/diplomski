private static final int MAX_OBJECT_SIZE = 1 << 21;

public MyDecoder() 
{
    super(MAX_OBJECT_SIZE, 0, 4, 0, 4);
}