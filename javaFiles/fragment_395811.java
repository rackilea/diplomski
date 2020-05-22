static void Foo2(Node n)
{
    Node n2 = n.clone();
    n2.x--;
    System.out.println("Foo2: " + n2);
}