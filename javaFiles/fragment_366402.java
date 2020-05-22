int max = 0; 
for(int ages : personAges){
  if(ages > max){
    max = ages; 
  }
}
System.out.println("The oldest person in the list is " + max);