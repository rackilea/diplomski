int first = 0;
int second = 1;

System.out.print(second);  
for (int i = 0; i <= 12; i++) {
    second = second + first;    // Now second equals to the sum of the first and old value of the second
    first = second - first;     // If subtract from second the value of first, we can get old value of the second

    System.out.print(", " + second);    
}