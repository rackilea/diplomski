private static void clientInputstream(int bufferSize) throws IOException, UnknownHostException
{
    long counter = 0;

    Socket client = new Socket(InetAddress.getLocalHost(), PORT);
    DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream(), bufferSize));

    try
    {
        for (;;)
        {
            long remoteTS = in.readLong();
            long remoteCounter = in.readLong();
            if (remoteCounter != counter)
            {
                String error = "ERROR: Expected remote counter to be " + counter + " but it was actually " + remoteCounter;
                //System.out.println(error);
                throw new RuntimeException(error);
            }
            counter++;

            long localTS = System.nanoTime();
            long latency = localTS - remoteTS;
            if (Math.abs(latency) > 1200000000)
            {
                out.println(String.format("ERROR: counter %s, remoteTS %s, localTS %s, diff %s",
                    counter, remoteTS, localTS, latency));
                continue;
            }
        }
    }
    catch (EOFException exc)
    {
        System.out.println("EOS");
    }
    finally
    {
        client.close();
    }
}