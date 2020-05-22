func(LinkedList ll)  
{  

    Set set = new HashSet(ll);  //removes all duplicates  
    if(set.contains("o")  {  set.remove("o") ;}  //these are strings so that works
    LinkedList newLL = new LinkedList(set);  //order still retained  
    newLL.poll();  //remove last element
}