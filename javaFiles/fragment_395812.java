@Override
public Node clone() throws CloneNotSupportedException { ... } //public!

static void Foo2(Node n)
{
    n.x--;
    System.out.println("Foo2: " + n);
}