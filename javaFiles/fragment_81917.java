public BigNum(long n) {

int number = (int)n;
int[] tempNum = new int[MAX_DIGITS];

int counter=0;
while(number>0) {
    tempNum[counter] = number % 10;
    number /= 10; 
    counter++;
}
this.num = Arrays.copyOfRange(tempNum, 0, counter);

}

public String toString(){
String toReturn = "";
if(this.num.length>=1 && this.num.length<=3) {
    for(int i=this.num.length-1 ; i>=0 ; i--) {
        toReturn += num[i];
    }
}else {
    int commaPos = this.num.length%3==0?3:this.num.length%3;
    int counter=0;
    while(counter<this.num.length) {
        if(counter==commaPos) {
            toReturn+=",";
            commaPos+=3;
        }
        toReturn+=num[this.num.length-1-counter]
        counter++;
    }
}
return toReturn;
}