private static Employee[] listOfEmployees(String[] firstNames, String[] lastNames, String[] idNumbers){     
   Employee[] list = new Employee[firstNames.length]; 

   for(int i=0; i<list.length; i++){
    list[i]=new Employee(firstNames[i], lastNames[i], idNumbers[i]);
   }    

  return list;
 }