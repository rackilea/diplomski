String str1 = "A*B*C";
String str2 = "C*A*B";

// split strings into arrays
String[] array1 = str1.split("*");
String[] array2 = str2.split("*");

// sort each array
Arrays.sort(array1);
Arrays.sort(array2);

// compare arrays
for( i=0; i<array1.length; i++ ){
   if(array1[i] == array2[i]){
       return false;   // OR, do whatever it is you want to do here.
   }
}