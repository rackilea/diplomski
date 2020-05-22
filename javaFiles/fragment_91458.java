22:47:41,071 DEBUG port.LoggingReporter| TEST STEP 1/2: send
22:47:41,085 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceInputEndpoint'
22:47:41,086 DEBUG nnel.ChannelProducer| Sending message to channel: 'input'
22:47:41,086 DEBUG nnel.ChannelProducer| Message to send is:
DEFAULTMESSAGE [id: 7d4f4c7a-92d0-462c-b695-c32fc7e697ae, payload: Req][headers: {citrus_message_type=XML, citrus_message_id=7d4f4c7a-92d0-462c-b695-c32fc7e697ae, citrus_message_timestamp=1539118061073}]
22:47:41,087 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'input'
22:47:41,091 DEBUG hannel.DirectChannel| preSend on channel 'input', message: 
GenericMessage [payload=Req, headers={citrus_message_timestamp=1539118061073, citrus_message_type=XML, id=33295f63-948f-6bcf-289f-d5e1df8dc98b, citrus_message_id=7d4f4c7a-92d0-462c-b695-c32fc7e697ae, timestamp=1539118061091}]
22:47:41,092 DEBUG endingMessageHandler| org.springframework.integration.ip.tcp.TcpSendingMessageHandler#0 received message:
GenericMessage [payload=Req, headers={citrus_message_timestamp=1539118061073, citrus_message_type=XML, id=33295f63-948f-6bcf-289f-d5e1df8dc98b, citrus_message_id=7d4f4c7a-92d0-462c-b695-c32fc7e697ae, timestamp=1539118061091}]
22:47:41,092 DEBUG entConnectionFactory| Opening new socket connection to 127.0.0.1:33500
22:47:41,106 DEBUG ion.TcpNioConnection| New connection localhost:33500:55108:33be3b24-f5ae-4594-83e9-c7eb0f104b1f
22:47:41,110 DEBUG entConnectionFactory| client: Added new connection: localhost:33500:55108:33be3b24-f5ae-4594-83e9-c7eb0f104b1f
22:47:41,113 DEBUG endingMessageHandler| Got Connection localhost:33500:55108:33be3b24-f5ae-4594-83e9-c7eb0f104b1f
22:47:41,114 DEBUG ion.TcpNioConnection| localhost:33500:55108:33be3b24-f5ae-4594-83e9-c7eb0f104b1f writing 4
22:47:41,116 DEBUG ion.TcpNioConnection| localhost:33500:55108:33be3b24-f5ae-4594-83e9-c7eb0f104b1f Message sent GenericMessage [payload=Req, headers={citrus_message_timestamp=1539118061073, citrus_message_type=XML, id=33295f63-948f-6bcf-289f-d5e1df8dc98b, citrus_message_id=7d4f4c7a-92d0-462c-b695-c32fc7e697ae, timestamp=1539118061091}]
22:47:41,117 DEBUG channel.DirectChannel| postSend (sent=true) on channel 'input', message: GenericMessage [payload=Req, headers={citrus_message_timestamp=1539118061073, citrus_message_type=XML, id=33295f63-948f-6bcf-289f-d5e1df8dc98b, citrus_message_id=7d4f4c7a-92d0-462c-b695-c32fc7e697ae, timestamp=1539118061091}]
22:47:41,118 INFO  nnel.ChannelProducer| Message was sent to channel: 'input'
22:47:41,118 INFO  port.LoggingReporter| 
22:47:41,119 DEBUG port.LoggingReporter| TEST STEP 1/2 SUCCESS
22:47:41,119 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceRepliesEndpoint'
22:47:41,120 INFO  port.LoggingReporter| 
22:47:41,121 DEBUG port.LoggingReporter| TEST STEP 2/2: receive
22:47:41,122 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceRepliesEndpoint'
22:47:41,124 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'response'
22:47:41,125 DEBUG nnel.ChannelConsumer| Receiving message from: response
22:47:46,130 INFO  port.LoggingReporter| 
22:47:46,131 ERROR port.LoggingReporter| TEST FAILED
sendSpringIntegrationMessageTest <com.consol.citrus.samples> Nested exception is: 
com.consol.citrus.exceptions.ActionTimeoutException: Action timeout while receiving message from channel 'response'
    ...