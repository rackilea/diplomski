public static void main (String[] args)
{
    LinkedList<String> l = new LinkedList<String>();
    LinkedList<String> copy = new LinkedList<String>();
    l.push("A"); l.push("B"); l.push("C"); l.push("D");
    l.push("E"); l.push("F"); l.push("G"); l.push("H");
    copy = l;

    while (copy.size() != 0) StdOut.println(copy.pop()+"  "); // remove this line
                                                              // and your method will
                                                              // work
    shuffle(l);
    while (l.size() != 0) StdOut.println(l.pop()+"  ");
}