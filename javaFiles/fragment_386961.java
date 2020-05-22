float sum = 0;
for(int j=0; j<a[0].length; j++){
    sum += a[1][j];   // i = 1 for second row
}
float average = sum / a[0].length;
System.out.println(average);