import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.logging.LogLevel;
....
final LoggingHandler loggingHandler = new LoggingHandler(getClass(), 
LogLevel.ERROR);
....
pipeline.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
pipeline.addLast("logger", loggingHandler);
pipeline.addLast(new ObjectEchoServerHandler());
....