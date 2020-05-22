void increment (int[] number) {
    int carry = 1;
    for(int i = 3; i >=0; i--) {
        number[i] += carry;
        if(number[i] == 256) {
            carry = 1;
            number[i] = 0;
        } else carry = 0;
    }
}