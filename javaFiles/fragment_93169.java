int count = 0;
loop (flag is true) 
  int index = find start index of query in src;
  if (query is found) 
    src = update the src with substring(index + query.length());
    count++;
  else 
    flag = false;      
return count;