19:23:16.867 [main] DEBUG org.springframework.integration.channel.DirectChannel - preSend on channel 'org.springframework.integration.channel.DirectChannel@1794d431', message: GenericMessage [payload=foo, headers={id=9c3b1493-0a9a-e324-6da3-262079677ed0, timestamp=1494199396867}]
org.springframework.messaging.MessageDeliveryException: failed to send Message to channel 'null'; nested exception is java.lang.RuntimeException: foo, failedMessage=GenericMessage [payload=foo, headers={id=9c3b1493-0a9a-e324-6da3-262079677ed0, timestamp=1494199396867}]
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:449)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:373)
    at com.example.So43836561Application.main(So43836561Application.java:16)
Caused by: java.lang.RuntimeException: foo
    at com.example.So43836561Application.lambda$0(So43836561Application.java:13)
    at com.example.So43836561Application$$Lambda$1/1121454968.handleMessage(Unknown Source)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.doDispatch(UnicastingDispatcher.java:160)
    at org.springframework.integration.dispatcher.UnicastingDispatcher.dispatch(UnicastingDispatcher.java:121)
    at org.springframework.integration.channel.AbstractSubscribableChannel.doSend(AbstractSubscribableChannel.java:89)
    at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:423)
    ... 2 more
19:23:18.875 [main] DEBUG org.springframework.integration.channel.DirectChannel - preSend on channel 'org.springframework.integration.channel.DirectChannel@1794d431', message: GenericMessage [payload=bar, headers={id=90aaa16c-a8c1-9162-ba8f-532fa3201c7f, timestamp=1494199398875}]
Second Service: GenericMessage [payload=bar, headers={id=90aaa16c-a8c1-9162-ba8f-532fa3201c7f, timestamp=1494199398875}]
19:23:18.876 [main] DEBUG org.springframework.integration.channel.DirectChannel - postSend (sent=true) on channel 'org.springframework.integration.channel.DirectChannel@1794d431', message: GenericMessage [payload=bar, headers={id=90aaa16c-a8c1-9162-ba8f-532fa3201c7f, timestamp=1494199398875}]