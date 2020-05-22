15:04:12,318 DEBUG port.LoggingReporter| TEST STEP 2/2: receive
15:04:12,319 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceRepliesEndpoint'
15:04:12,319 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'replies'
15:04:12,319 DEBUG nnel.ChannelConsumer| Receiving message from: replies
15:04:12,327 DEBUG ion.TcpNioConnection| localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195 Reading...
15:04:12,328 DEBUG ion.TcpNioConnection| localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195 Running an assembler
15:04:12,329 DEBUG ion.TcpNioConnection| Read 4 into raw buffer
15:04:12,329 DEBUG ion.TcpNioConnection| localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195 Reading...
15:04:12,330 DEBUG ion.TcpNioConnection| Read 0 into raw buffer
15:04:12,332 DEBUG yteArrayLfSerializer| Available to read:4
15:04:12,333 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'messageBuilderFactory'
15:04:12,336 DEBUG channel.QueueChannel| preSend on channel 'replies', message: GenericMessage [payload=byte[3], headers={ip_tcp_remotePort=33500, ip_connectionId=localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195, ip_localInetAddress=0.0.0.0/0.0.0.0, ip_address=127.0.0.1, id=9bd90a54-cc2b-d3d0-ca63-6355f53dee7c, ip_hostname=localhost, timestamp=1539176652336}]
15:04:12,339 DEBUG channel.QueueChannel| postReceive on channel 'replies', message: GenericMessage [payload=byte[3], headers={ip_tcp_remotePort=33500, ip_connectionId=localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195, ip_localInetAddress=0.0.0.0/0.0.0.0, ip_address=127.0.0.1, id=9bd90a54-cc2b-d3d0-ca63-6355f53dee7c, ip_hostname=localhost, timestamp=1539176652336}]
15:04:12,340 DEBUG nnel.ChannelConsumer| Received message from: replies
15:04:12,340 DEBUG tListableBeanFactory| Returning cached instance of singleton bean 'citrusServiceRepliesEndpoint'
15:04:12,354 DEBUG channel.QueueChannel| postSend (sent=true) on channel 'replies', message: GenericMessage [payload=byte[3], headers={ip_tcp_remotePort=33500, ip_connectionId=localhost:33500:56004:1174f4c6-608c-44c6-aeec-33da4074e195, ip_localInetAddress=0.0.0.0/0.0.0.0, ip_address=127.0.0.1, id=9bd90a54-cc2b-d3d0-ca63-6355f53dee7c, ip_hostname=localhost, timestamp=1539176652336}]
15:04:12,379 INFO  port.LoggingReporter| 
15:04:12,381 ERROR port.LoggingReporter| TEST FAILED sendSpringIntegrationMessageTest <com.consol.citrus.samples> Nested exception is: 
com.consol.citrus.exceptions.CitrusRuntimeException: Could not find proper message validator for message type 'XML', please define a capable message validator for this message type