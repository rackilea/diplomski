char[] ISBN = ninedigitNum.toCharArray();

//Process each number
int total = 0;
for(int i=0; i<9; i++){
    int current_int = Integer.parseInt(ISBN[i]);
    total += current_int * (10 - i)
}

//Find value of d1
for(int i=0; i<9; i++){
    if(((total + i) % 11) == 0){
        total += i*100000000;
        break;
    }
}

return total;