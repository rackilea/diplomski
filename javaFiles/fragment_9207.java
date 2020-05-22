import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class DirectByteBufferSliceOffsetsTest
{
    public static void main(String[] args)
    {
        testArray();
        testDirect();
    }

    private static void testArray()
    {
        System.out.println("Array: ");

        ByteBuffer buffer1 = ByteBuffer.allocate(10000);
        buffer1.position(22);
        ByteBuffer buffer2 = buffer1.slice();
        buffer2.position(55);
        ByteBuffer buffer3 = buffer2.slice();

        // prints 22
        System.out.println(getRelativeBufferOffsetArray(buffer1, buffer2));

        // prints 55
        System.out.println(getRelativeBufferOffsetArray(buffer2, buffer3));

        // prints 77
        System.out.println(getRelativeBufferOffsetArray(buffer1, buffer3));
    }

    private static int getRelativeBufferOffsetArray(
        ByteBuffer parentBuffer, ByteBuffer childBuffer)
    {
        return childBuffer.arrayOffset() - parentBuffer.arrayOffset();
    }


    private static void testDirect()
    {
        System.out.println("Direct: ");

        ByteBuffer buffer1 = ByteBuffer.allocateDirect(10000);
        buffer1.position(22);
        ByteBuffer buffer2 = buffer1.slice();
        buffer2.position(55);
        ByteBuffer buffer3 = buffer2.slice();

        // prints 22
        System.out.println(getRelativeBufferOffsetDirect(buffer1, buffer2));

        // prints 55
        System.out.println(getRelativeBufferOffsetDirect(buffer2, buffer3));

        // prints 77
        System.out.println(getRelativeBufferOffsetDirect(buffer1, buffer3));
    }

    private static int getRelativeBufferOffsetDirect(
        ByteBuffer parentBuffer, ByteBuffer childBuffer)
    {
        long parentAddress = getAddress(parentBuffer);
        long childAddress = getAddress(childBuffer);
        int offset = (int)(childAddress - parentAddress);
        return offset;
    }

    private static long getAddress(Buffer buffer)
    {
        Field f = null;
        try
        {
            f = Buffer.class.getDeclaredField("address");
            f.setAccessible(true);
            return f.getLong(buffer);
        }
        catch (NoSuchFieldException e)
        {
            // Many things...
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            // ... can go ...
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // ... wrong when...
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // ... using reflection
            e.printStackTrace();
        }
        finally
        {
            if (f != null)
            {
                f.setAccessible(false);
            }
        }
        return 0;
    }
}