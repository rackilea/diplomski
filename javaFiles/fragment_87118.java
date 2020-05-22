List<String> resultList = new ArrayList<String>();
for (String l1 : list1)
{ 
    boolean stay = true;
    for (String l2 : list2)
           if (l1.contains(l1))
               stay = false;
    if (stay)
       resultList.add(l1);

}