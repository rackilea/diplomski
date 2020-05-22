String[] matches = input[0].split(" ");           
for (int i=0; i <3; i++){
  for(String s: matches){
    if(given[i].contains(s))
      System.out.println(given[i]);
      break;
     }      
  }
}