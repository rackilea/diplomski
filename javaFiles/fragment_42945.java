for(int i = 0; i < numbers.length; i++) {
     int addVal = (int)(Math.random()*400+1); 
     boolean duplicate = IntStream.of(numbers).anyMatch(x -> x == addVal); 
     if(addVal != 0 && duplicate == false) { 
         numbers[i] = addVal; //add it to the list
     } else {
        i--;
     }
}