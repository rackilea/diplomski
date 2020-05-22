import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * Socket Gateway for SO Question 7528528
 * User: jhawk28
 * Date: 9/26/11
 * Time: 9:03 PM
 * <p/>
 * http://stackoverflow.com/questions/7528528/java-ports-sockets-piping-a-connection-through-a-programme
 */
public class Gateway
{
  public static void main(String[] args) throws IOException
  {
    // Set up Server Socket and bind to the port 8000
    ServerSocketChannel server = ServerSocketChannel.open();
    SocketAddress endpoint = new InetSocketAddress(8000);
    server.socket().bind(endpoint);

    server.configureBlocking(false);

    // Set up selector so we can run with a single thread but multiplex between 2 channels
    Selector selector = Selector.open();
    server.register(selector, SelectionKey.OP_ACCEPT);


    ByteBuffer buffer = ByteBuffer.allocate(1024);

    while (true)
    {
      // block until data comes in
      selector.select();

      Set<SelectionKey> keys = selector.selectedKeys();

      for (SelectionKey key : keys)
      {
        if (!key.isValid())
        {
          // not valid or writable so skip
          continue;
        }

        if (key.isAcceptable())
        {
          // Accept socket channel for client connection
          ServerSocketChannel channel = (ServerSocketChannel) key.channel();
          SocketChannel accept = channel.accept();
          setupConnection(selector, accept);
        }
        else if (key.isReadable())
        {
          try
          {
            // Read into the buffer from the socket and then write the buffer into the attached socket.
            SocketChannel recv = (SocketChannel) key.channel();
            SocketChannel send = (SocketChannel) key.attachment();
            recv.read(buffer);
            buffer.flip();
            send.write(buffer);
            buffer.rewind();
          } catch (IOException e)
          {
            e.printStackTrace();

            // Close sockets
            if (key.channel() != null)
              key.channel().close();
            if (key.attachment() != null)
              ((SocketChannel) key.attachment()).close();
          }
        }
      }

      // Clear keys for next select
      keys.clear();
    }
  }

  public static void setupConnection(Selector selector, SocketChannel client) throws IOException
  {
    // Connect to the remote server
    SocketAddress address = new InetSocketAddress("192.168.1.74", 8000);
    SocketChannel remote = SocketChannel.open(address);

    // Make sockets non-blocking (should be better performance)
    client.configureBlocking(false);
    remote.configureBlocking(false);

    client.register(selector, SelectionKey.OP_READ, remote);
    remote.register(selector, SelectionKey.OP_READ, client);
  }
}