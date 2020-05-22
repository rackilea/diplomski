while(count<list.size()- 1)
    {
         String temp=list.get(count);
         temp.replaceAll("[^a-zA-z ]", ""); //null pointer points to this line
         temp.toLowerCase();                //and this line
         list.set(count, temp);
         count++;
    }