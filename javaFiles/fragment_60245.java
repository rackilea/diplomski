Scanner s = new Scanner(new File("YourFileHere.txt"));
ArrayList<String> entries = new ArrayList<String>();
while(s.hasNext())
{
    entries.add(s.next() + " " + s.next() + " " s.next());
}