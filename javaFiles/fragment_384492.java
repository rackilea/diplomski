public Counter(int startingValue, boolean check) {
    this.check = check;
    if (check == true) {
        value = startingValue;
        if (value < 0) {
            value = 0;
        }
    }
    else {
        value = startingValue;
    }    
}