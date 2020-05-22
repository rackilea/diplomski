import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.asyncweb.common.codec.HttpCodecFactory;
import org.apache.asyncweb.examples.lightweight.HttpProtocolHandler;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class Main {
    public static void main(String[] args) throws Exception {
        SocketAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new HttpCodecFactory()));

        acceptor.setReuseAddress(true);
        acceptor.getSessionConfig().setReuseAddress(true);
        acceptor.getSessionConfig().setReceiveBufferSize(1024);
        acceptor.getSessionConfig().setSendBufferSize(1024);
        acceptor.getSessionConfig().setTcpNoDelay(true);
        acceptor.getSessionConfig().setSoLinger(-1);
        acceptor.setBacklog(10240);

        acceptor.setHandler(new HttpProtocolHandler());
        acceptor.bind(new InetSocketAddress(9012));
    }
}