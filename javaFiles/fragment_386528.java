int arr1Digits = 0, arr2Digits = 0;
for(int x=0; x<arr1.length; x++)
    arr1Digits += String.valueOf(Math.abs(arr1[x])).length();    //Sum of digits in arr1

for(int x=0; x<arr2.length; x++)
    arr2Digits += String.valueOf(Math.abs(arr2[x])).length();    //Sum of digits in arr2


int diff = arr1Digits - arr2Digits;