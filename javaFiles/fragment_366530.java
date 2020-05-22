int smallest = 100000   

 for (int i = 0; i < array.length; i++)

    if(array[i+1]-array[i]<smallest)
     {
       smallest = array[i+1]-array[i];
     }

System.out.println(smallest);