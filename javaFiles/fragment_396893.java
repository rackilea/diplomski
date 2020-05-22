for (int i = 0 ; i < temp.length ; i++) {
    if (i!=0 && i!=4 && i!=5 && i!=9) {
        temp[i] = (char)(numbers[counter] + (int)'0');
        counter++;
    }
}