//array1 has [2 3 4 1 2 3 4 1]
 //array2 has [1 2 3 4]
 boolean check = false;
 for(int i = 0; i < array1.length(); i++) {
   for(int j; j < array2.length(); j++) {
      if((i+j) <= array1.length()) {
        if(array1[i+j] == array2[j])
            check = true;
        else
            check = false;
      }
   }
   if(check)
       return true; // returns true if all array2 == some part of array1
 }
 return false;