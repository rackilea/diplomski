int k = 0;
while (k < 20 && str.nextToken() != str.TT_EOL) {
    if (str.ttype == StreamTokenizer.TT_NUMBER) {
        System.out.println(i);
        array[i++] = (int) str.nval;
        k++;
    }
}