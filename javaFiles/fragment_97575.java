for (Text value : values) {
   if (checkEven) {
       evenFound |= "YES".equals(value);
   } else {
       oddFound |= "YES".equals(value);
   }

   if (evenFound && oddFound) {
       result = true;
       break;
   }

   checkEven = !checkEven;
}