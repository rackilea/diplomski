int sum = 0;
int currentIn = in;
for(int i = 0; i < in; i++) {
    sum = sum + (in - i) * currentIn;
    currentIn = currentIn * 10;
}
System.out.println(sum);