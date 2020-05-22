String [] array = temp.split("\\s+"); // split by whitespace
Arrays.sort(array); // sort using mergesort with insertionsort

StringBuilder sb = new StringBuilder(temp.length());

 for(String s : array){
     sb.append(s).append(" "); 
 }

temp = sb.toString(); // assign temp the new string