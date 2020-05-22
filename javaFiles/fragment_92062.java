while(token.hasNext())
{
    String name = token.next();
    int count = NameCount.containsKey(name) ? NameCount.get(name) : 0;
    NameCount.put(name, count + 1);
}