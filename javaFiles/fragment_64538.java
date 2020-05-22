public static void main(String[] args) 
{
    List listA = new ArrayList();
    listA.add(1);
    listA.add(2);
    listA.add(3);
    listA.add(4);
    List listB = new ArrayList();
    listB.add(2);
    listB.add(4);
    Set hashset = new HashSet(listA);

    for(int i = 0; i < listB.size(); i++) 
    {
        if(hashset.contains(listB.get(i))) 
        {
            listC.add(i);
            System.out.println(i);
        }
    }   
}