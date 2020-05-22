int count = 0;
for (boolean x: theArray){
   if (x) {
       count++;
       if (count >= n) return true;  // n is the count we are looking for
   } else { count = 0; }
}
return false;