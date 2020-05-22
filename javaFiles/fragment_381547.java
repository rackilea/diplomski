b = 4;
a = 5;

for(int i = 1; i <= b; i++) {
    if(i*a % b == 0)
        return abs(i*a);
}