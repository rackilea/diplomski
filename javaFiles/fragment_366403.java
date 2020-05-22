int maxAge = 0; 
for(Person p : personList){
  int pAge = p.getAge();
  if(pAge  > maxAge){
    maxAge = pAge; 
  }
}

System.out.println("The oldest person in the list is " + maxAge + " years old");