public class Custom implements Collection {
    Collection c; // create an instance here or in the constructor
    ...

    // forwarding method
    public Iterator iterator()
    {
        return c.iterator();
    }
}