ServerSocket serverSock = new ServerSocket(2000);

while (true)
{
    Socket fpSock = serverSock.accept();
    MyThread t = new MyThread(fpSock, this);
    t.start();
}