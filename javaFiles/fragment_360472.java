int a = (1 << 6) ^ (1 << 7);
int temp = a;
for(int i=0;i<32;i++) {
    if((temp&1)==1) 
        System.out.println("number: " + i);
    temp = temp >> 1;
}