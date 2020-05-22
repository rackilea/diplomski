/**
 * This class implements client sockets (also called just
 * "sockets"). A socket is an endpoint for communication
 * between two machines.
 * <p>
 * The actual work of the socket is performed by an instance of the
 * {@code SocketImpl} class. An application, by changing
 * the socket factory that creates the socket implementation,
 * can configure itself to create sockets appropriate to the local
 * firewall.
 *
 * @author  unascribed
 * @see     java.net.Socket#setSocketImplFactory(java.net.SocketImplFactory)
 * @see     java.net.SocketImpl
 * @see     java.nio.channels.SocketChannel
 * @since   JDK1.0
 */
public
class Socket implements java.io.Closeable