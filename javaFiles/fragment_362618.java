Node tmp = first;

if (tmp == null)
{
    StdOut.println("");
    return;
}

do
{
    StdOut.println(tmp.p.toString());
    tmp = tmp.next;
} while (tmp != first);