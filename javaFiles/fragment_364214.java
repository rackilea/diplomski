if (data[1].contains(country) == true){
   System.out.println("Country name: " + data[1]);
   System.out.println("Mobile phone subscribers: " + data[2]);
   return;
 } else {
   System.out.println("No country found with that name!");
   return; //<-----ISSUE
 }