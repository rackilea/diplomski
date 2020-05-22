Sep 13, 2018 9:05:06 PM com.hazelcast.client.ClientEndpointManager
INFO: [127.0.0.1]:5701 [dev] [3.10.4] Destroying ClientEndpoint{connection=Connection[id=32, /172.17.0.2:5701->/172.17.0.1:56574, endpoint=[172.17.0.1]:56574, alive=false, type=JAVA_CLIENT], principal='ClientPrincipal{uuid='99cbf1b4-d11c-462d-bd87-4c069bc9b2ef', ownerUuid='2fb66fa1-a17f-49fe-ba2b-bf585d43906d'}, ownerConnection=true, authenticated=true, clientVersion=3.10.4, creationTime=1536872631771, latest statistics=null}
Sep 13, 2018 9:05:19 PM com.hazelcast.nio.tcp.TcpIpAcceptor
INFO: [127.0.0.1]:5701 [dev] [3.10.4] Accepting socket connection from /172.17.0.1:56576
Sep 13, 2018 9:05:19 PM com.hazelcast.nio.tcp.TcpIpConnectionManager
INFO: [127.0.0.1]:5701 [dev] [3.10.4] Established socket connection between /172.17.0.2:5701 and /172.17.0.1:56576
Sep 13, 2018 9:05:19 PM com.hazelcast.client.impl.protocol.task.AuthenticationMessageTask
INFO: [127.0.0.1]:5701 [dev] [3.10.4] Received auth from Connection[id=33, /172.17.0.2:5701->/172.17.0.1:56576, endpoint=null, alive=true, type=JAVA_CLIENT], successfully authenticated, principal: ClientPrincipal{uuid='ff51de39-fd9c-4ecf-bdd4-bbdb6ec6c79e', ownerUuid='2fb66fa1-a17f-49fe-ba2b-bf585d43906d'}, owner connection: true, client version: 3.10.4