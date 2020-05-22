ArrayList<String> list = new ArrayList<>();

list.add("fsfs.txt");
list.add("erwre.txt");
list.add("wery.txt");
list.add("wtrtr.txt");
list.add("erwre.txt");
list.add("qweq.txt");

// Sort the list
Collections.sort(list);

// Test if List was sorted correctly
for(String s : list)
{
    System.out.println(s);
}

System.out.println("\n*** Now try to get duplicates ***\n");

Iterator<String> listIt = list.iterator();

String prev = "";
boolean foundDuplicate = false;
while(listIt.hasNext())
{
    String current = listIt.next();

    if(current.equals(prev))
        foundDuplicate = true;
    else
        foundDuplicate = false;

    if(foundDuplicate)
    {
        // Duplicate found!
        System.out.println(current);
    }

    prev = current;
}