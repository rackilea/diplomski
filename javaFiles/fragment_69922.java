public class Server<H>
{
    public ArrayList<H<S>> handlers;

    public Server()
    {
        handlers = new ArrayList<H<S>>();
    }

    public void addHandler(H<S> c)
    {
        handlers.add(c);
    }
}