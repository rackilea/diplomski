new Thread(() ->
{
    Server s = new Server();
    s.Start();
}).start();

new Thread(() ->
{
    Client c = new Client();
    c.Start();
}).start();