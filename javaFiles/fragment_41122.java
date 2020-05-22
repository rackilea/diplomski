String[] All = {"apple", "fish", "cat","dog", "mouse"};
List<String> list = Arrays.asList(All);
Collections.shuffle(list);
System.out.println(list.toString());
for(int i = 0; i < list.size(); i++)
{
    if(list.get(i).equals("apple"))
    {
        System.out.println("Apple at index: " + i);
        break;
    }
}