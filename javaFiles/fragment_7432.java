String a;
    String b;
    Person c;
    Person d;

    for (int i= 0; i< list.size() ; i++){

        for(int j=0; j< list.size() - i-1; j++){

             a = list.get(j).getLastName().toUpperCase().trim();
             b = list.get(j+1).getLastName().toUpperCase().trim();

             c = list.get(j);
             d = list.get(j+1);

             if ( a.compareTo(b) > 0)  {

                 Person temp = d;  
                 list.set(j+1, c);
                 list.set(j, temp);

             } 
        }