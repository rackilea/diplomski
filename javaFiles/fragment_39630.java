if (balance[index] == 0 && acctNum[index] != 0) {
    numaccts--;
    acctNum[index] = 0;//handles case when index is at the end
    for(int count=index;count<numaccts;count++){//start from hole, shift over from beyond there
        acctNum[count]=acctNum[count+1];
        balance[count]=balance[count+1];
    }
acctNum[numaccts]=0;
balance[numaccts]=0;
}