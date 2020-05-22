11:40:54,924 DEBUG port.LoggingReporter| TEST STEP 2/2: receive
11:40:54,925 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceRepliesEndpoint'
11:40:54,925 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'response'
11:40:54,925 DEBUG nnel.ChannelConsumer| Receiving message from: response
11:40:54,928 DEBUG ion.TcpNioConnection| localhost:33500:55890:7537f5ed-f447-4b76-ba66-2ec59c7619a9 Reading...
11:40:54,929 DEBUG ion.TcpNioConnection| localhost:33500:55890:7537f5ed-f447-4b76-ba66-2ec59c7619a9 Running an assembler
11:40:54,929 DEBUG ion.TcpNioConnection| Read 4 into raw buffer
Exception in thread "pool-1-thread-3" java.lang.AbstractMethodError: org.springframework.integration.ip.tcp.connection.TcpMessageMapper.toMessage(Ljava/lang/Object;)Lorg/springframework/messaging/Message;
    at org.springframework.integration.ip.tcp.connection.TcpNioConnection.convert(TcpNioConnection.java:358)
    at org.springframework.integration.ip.tcp.connection.TcpNioConnection.run(TcpNioConnection.java:235)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)
11:40:54,937 DEBUG ion.TcpNioConnection| localhost:33500:55890:7537f5ed-f447-4b76-ba66-2ec59c7619a9 Reading...
11:40:54,938 DEBUG ion.TcpNioConnection| Read 0 into raw buffer
11:40:59,930 INFO  port.LoggingReporter| 
11:40:59,931 ERROR port.LoggingReporter| TEST FAILED sendSpringIntegrationMessageTest <com.consol.citrus.samples> Nested exception is: 
com.consol.citrus.exceptions.ActionTimeoutException: Action timeout while receiving message from channel 'response'