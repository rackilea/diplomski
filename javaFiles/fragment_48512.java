int numberOfContacts = listofContacts.size()/6;
    Object[][] newArrayContent = new Object[numberOfContacts][6];

    for(int x = 0; x<numberOfContacts; x++){
        for(int z = 0; z < 6; z++){
        int y = 6 * x;
        newArrayContent [x][z] = list.get(y+z); 
        System.out.println(newArrayContent [x][z].toString());
        }
    }