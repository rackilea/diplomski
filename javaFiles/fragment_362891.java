import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashSet;
import java.util.Set;

public class Main
{
    public static void main(final String[] argv)
    {
        ArrayTest.main(argv);
        ArrayTest.main(argv);
        DataInputByteAtATime.main(argv);
        DataInputReadFully.main(argv);
        MemoryMapped.main(argv);
    }
}

abstract class Test
{
    public final void run(final File root)
    {
        final Set<File> files;
        final long      size;
        final long      start;
        final long      end;
        final long      total;

        files = new HashSet<File>();
        getFiles(root, files);

        start = System.currentTimeMillis();

        size = readFiles(files);

        end = System.currentTimeMillis();
        total = end - start;

        System.out.println(getClass().getName());
        System.out.println("time  = " + total);
        System.out.println("bytes = " + size);
    }

    private void getFiles(final File      dir,
                          final Set<File> files)
    {
        final File[] childeren;

        childeren = dir.listFiles();

        for(final File child : childeren)
        {
            if(child.isFile())
            {
                files.add(child);
            }
            else
            {
                getFiles(child, files);
            }
        }
    }

    private long readFiles(final Set<File> files)
    {
        long size;

        size = 0;

        for(final File file : files)
        {
            size += readFile(file);
        }

        return (size);
    }

    protected abstract long readFile(File file);
}

class ArrayTest
    extends Test
{
    public static void main(final String[] argv)
    {
        final Test test;

        test = new ArrayTest();
        test.run(new File(argv[0]));
    }

    protected long readFile(final File file)
    {
        InputStream stream;

        stream = null;

        try
        {
            final byte[] data;
            int          soFar;
            int          sum;

            stream = new BufferedInputStream(new FileInputStream(file));
            data   = new byte[(int)file.length()];
            soFar  = 0;

            do
            {
                soFar += stream.read(data, soFar, data.length - soFar);
            }
            while(soFar != data.length);

            sum = 0;

            for(final byte b : data)
            {
                sum += b;
            }

            return (sum);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stream != null)
            {
                try
                {
                    stream.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return (0);
    }
}

class DataInputByteAtATime
    extends Test
{
    public static void main(final String[] argv)
    {
        final Test test;

        test = new DataInputByteAtATime();
        test.run(new File(argv[0]));
    }

    protected long readFile(final File file)
    {
        DataInputStream stream;

        stream = null;

        try
        {
            final int fileSize;
            int       sum;

            stream   = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            fileSize = (int)file.length();
            sum      = 0;

            for(int i = 0; i < fileSize; i++)
            {
                sum += stream.readByte();
            }

            return (sum);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stream != null)
            {
                try
                {
                    stream.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return (0);
    }
}

class DataInputReadFully
    extends Test
{
    public static void main(final String[] argv)
    {
        final Test test;

        test = new DataInputReadFully();
        test.run(new File(argv[0]));
    }

    protected long readFile(final File file)
    {
        DataInputStream stream;

        stream = null;

        try
        {
            final byte[] data;
            int          sum;

            stream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            data   = new byte[(int)file.length()];
            stream.readFully(data);

            sum = 0;

            for(final byte b : data)
            {
                sum += b;
            }

            return (sum);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stream != null)
            {
                try
                {
                    stream.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return (0);
    }
}

class DataInputReadInChunks
    extends Test
{
    public static void main(final String[] argv)
    {
        final Test test;

        test = new DataInputReadInChunks();
        test.run(new File(argv[0]));
    }

    protected long readFile(final File file)
    {
        DataInputStream stream;

        stream = null;

        try
        {
            final byte[] data;
            int          size;
            final int    fileSize;
            int          sum;

            stream   = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            fileSize = (int)file.length();
            data     = new byte[512];
            size     = 0;
            sum      = 0;

            do
            {
                size += stream.read(data);

                sum = 0;

                for(int i = 0; i < size; i++)
                {
                    sum += data[i];
                }
            }
            while(size != fileSize);

            return (sum);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stream != null)
            {
                try
                {
                    stream.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return (0);
    }
}
class MemoryMapped
    extends Test
{
    public static void main(final String[] argv)
    {
        final Test test;

        test = new MemoryMapped();
        test.run(new File(argv[0]));
    }

    protected long readFile(final File file)
    {
        FileInputStream stream;

        stream = null;

        try
        {
            final FileChannel      channel;
            final MappedByteBuffer buffer;
            final int              fileSize;
            int                    sum;

            stream   = new FileInputStream(file);
            channel  = stream.getChannel();
            buffer   = channel.map(MapMode.READ_ONLY, 0, file.length());
            fileSize = (int)file.length();
            sum      = 0;

            for(int i = 0; i < fileSize; i++)
            {
                sum += buffer.get();
            }

            return (sum);
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stream != null)
            {
                try
                {
                    stream.close();
                }
                catch(final IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return (0);
    }
}