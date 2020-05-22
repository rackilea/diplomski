public class Server<H>
{
    public ArrayList<H<self>> handlers;

    public Server()
    {
        handlers = new ArrayList<H<self>>();
    }

    public void addHandler(H<self> c)
    {
        handlers.add(c);
    }
}