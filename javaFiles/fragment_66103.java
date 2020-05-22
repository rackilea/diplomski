// assume los is a list of Strings
final Iterator<String> it = los.iterator();
for (int i = 0; it.hasNext(); i++)
{
    System.out.format("index %d = %s", i, it.next());
}