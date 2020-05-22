System.out.println("Before sorting-->" +c );
    for (int i = 0; i < c.size()-1; i++) {
       for(int j=i+1; j <c.size();j++)
       {
           if(c.get(i) > c.get(j))
           {
               int temp = c.get(j);
               c.set(j, c.get(i));
               c.set(i, temp);
           }
       }
    }
    System.out.println("After sorting-->" +c );