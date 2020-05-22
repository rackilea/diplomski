int count = 0;
for(String team : mlb){ // Will run through the file and display the ArrayList.
   if(team.contains(userInput))
      count++;
}
System.out.println(count);