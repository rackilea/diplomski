19:26:38.005 [main] DEBUG org.springframework.integration.channel.DirectChannel - preSend on channel 'org.springframework.integration.channel.DirectChannel@7d9d1a19', message: GenericMessage [payload=foo, headers={id=6a69efe9-dbbd-c79b-41a9-6964fd4c8ccc, timestamp=1494199598004}]
org.springframework.messaging.MessageDeliveryException: failed to send Message to channel 'null'; nested exception is java.lang.RuntimeException: foo, failedMessage=GenericMessage [payload=foo, headers={id=6a69efe9-dbbd-c79b-41a9-6964fd4c8ccc, timestamp=1494199598004}]
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:449)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:373)
    at com.example.So43836561Application.main(So43836561Application.java:16)
Caused by: java.lang.RuntimeException: foo
    at com.example.So43836561Application.lambda$0(So43836561Application.java:13)
    at com.example.So43836561Application$$Lambda$1/2009787198.handleMessage(Unknown Source)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.doDispatch(UnicastingDispatcher.java:160)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.dispatch(UnicastingDispatcher.java:121)
    at org.springframework.integration.channel.AbstractSubscribableChannel.doSend(AbstractSubscribableChannel.java:89)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:423)
    ... 2 more
19:26:40.009 [main] DEBUG org.springframework.integration.channel.DirectChannel - preSend on channel 'org.springframework.integration.channel.DirectChannel@7d9d1a19', message: GenericMessage [payload=bar, headers={id=9428a10e-3a17-79d5-e4bd-731fc88ef0fe, timestamp=1494199600008}]
Exception in thread "main" org.springframework.messaging.MessageDeliveryException: failed to send Message to channel 'null'; nested exception is java.lang.RuntimeException: foo, failedMessage=GenericMessage [payload=bar, headers={id=9428a10e-3a17-79d5-e4bd-731fc88ef0fe, timestamp=1494199600008}]
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:449)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:373)
    at com.example.So43836561Application.main(So43836561Application.java:22)
Caused by: java.lang.RuntimeException: foo
    at com.example.So43836561Application.lambda$0(So43836561Application.java:13)
    at com.example.So43836561Application$$Lambda$1/2009787198.handleMessage(Unknown Source)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.doDispatch(UnicastingDispatcher.java:160)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.dispatch(UnicastingDispatcher.java:121)
    at org.springframework.integration.channel.AbstractSubscribableChannel.doSend(AbstractSubscribableChannel.java:89)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:423)
    ... 2 more