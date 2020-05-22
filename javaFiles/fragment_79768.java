int size=personData.size();//get size of personData
String dataQ[]=new String[size];//change String dataQ to dataQ[]; 

 for(int i = 0; i < personData.size(); i++)
      {
            dataQ[i] = personData.get(i).getLastName() + " " + personData.get(i).getFirstName();
      }