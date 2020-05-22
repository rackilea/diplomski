setup:
List sockets = []
sockets << Mock(Socket)
sockets << Mock(Socket)
// repeat as needed
socket[3].isClosed() >> {Thread.sleep(1000);false}
serverSocket.accept() >> {sockets[socketNumber]}
// add different mock behavior
// when block
// then
where:
socketNumber << [1,2,3]