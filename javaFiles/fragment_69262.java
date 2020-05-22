import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect SocketExceptionLoggerAspect {

    private static final Logger logger = LoggerFactory
            .getLogger(SocketExceptionLoggerAspect.class);

    pointcut callToSocketConnect(SocketAddress target): 
        call(void Socket+.connect(..)) && args(target, ..);

    void around(SocketAddress target, Socket socket) : 
        callToSocketConnect(target) && target(socket) {

        int localPort = socket.getLocalPort();
        if (localPort == -1) {
            try {
                socket.bind(null);
                localPort = socket.getLocalPort();
            } catch (IOException e) {
            }
        }
        try {
            proceed(target, socket);
        } catch (IOException e) {
            logger.error(String.format("couldn't connect to %s from port %d", target,
                    localPort), e);
        }
    }
}