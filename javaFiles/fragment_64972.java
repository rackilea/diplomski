public int method(int number){
    int count;
for(count = 0; number > 0 ; count++){
    if((number % 10) != 2){
        count--;
    }
    number = number / 10;
}
return count;
}