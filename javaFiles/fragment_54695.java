public static void main(String[] args)
{
    Collection<Object> c = new HashSet<Object>();
    String h = "Hello World!";
    c.add(h);
    c.add(h);
    System.out.println("c contains " + c.size() + " item(s): " + c);
    System.out.println("c is an instance of " + c.getClass());
}