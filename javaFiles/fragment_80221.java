ArrayList<String> array =  new ArrayList<String>();
for(int i=0;i<mT.length;i++)
{
    for(int j=0;j<mT2.length;j++)
    {
        if(mT[i].equals(mT2[j]))
        {
            System.out.println("Equal Values are :"+mT2[j]);
        }
        else
        {
            System.out.println(" Not- Equal Values are :"+mT2[j]);
             if(!array.contains(mT2[j]) // checking whether the arraylist contains the object
                 array.add(mT2[j]); // adding the content to arraylist. Now it will not contain duplicates
        }
    }
}