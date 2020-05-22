List<String> list = new ArrayList<String>();
list.add("\n Ajax\n");
list.add("\n JavaScript\n");

for(int i = 0; i < list.size(); i++)
{
    String s = list.get(i).trim();
    list.set(i, s);
}