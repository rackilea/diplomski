private String getPaddedNumber(int number, int maxNumber) {
    if(maxNumber <= number) return Integer.toString(number);

    int buffer = number;
    while((buffer /= 10) != 0 & (maxNumber /= 10) != 0) {
        //nothing
    }

    StringBuilder sb = new StringBuilder();
    while(maxNumber != 0) {
        sb.append('0'); //alternatively sb.append(' ');
        maxNumber /= 10;
    }

    return sb.append(number).toString();
}