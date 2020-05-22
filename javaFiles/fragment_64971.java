public int method(int number){

int count = 0;
    while(number > 0) {
        if (number % 10 == 2) {
            count++;
        }
        number = number / 10;
    }
    return count;
}