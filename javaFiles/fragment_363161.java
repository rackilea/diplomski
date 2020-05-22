public int[] revCalculator(int[] number) {
    int[] reverse = new int[number.length]; //Initialize it to the same size as the passed in arary
    //int[] reverse = null; //Problem
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < number.length; j++) 
    {
        //You could convert the number to string then reverse it and use parseInt() int
        reverse[j] = parseInt(sb.append(number[j].toString()).reverse().toString());
        //Clear the StringBuilder object
        sb.setLength(0);

    }
    return reverse;
}