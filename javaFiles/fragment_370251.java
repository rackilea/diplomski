int a[] = {2, 3, 5, 7, 11, 13};
System.out.print("The average of \n" + Arrays.toString(a));  // print the array

for(int i = 0; i < a.length; i++)
  sum = sum + a[i];

double avg = (double)sum / a.length;  // cast one of the value to double

System.out.format(" is %.2f", avg);   // print the output upto two decimal.