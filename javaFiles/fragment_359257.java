long number;
int cnt1 = 0;
int cnt2 = 0;
long test = 3;
int counter = 0;    

while(counter < 64) { // we have 64 bits to inspect
    if((number & test) == 3) { // last 2 bits are 11
        cnt1++;
    } else { // last 2 bits are either 10, 01 or 00
        cnt2++;
    }          
    counter += 2;
    number = number >>> 2; // shift by 2 bits to the right
}