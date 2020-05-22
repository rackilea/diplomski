static int b(int num){
     int sum = 0;
     for (int index = num; index < a.length; index++) {
        sum = sum + a[index];
     }
     return sum;
}