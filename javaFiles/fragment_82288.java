for (int k = 0; k < 20 && str.nextToken() != str.TT_EOL; k++) {
    if (str.ttype == StreamTokenizer.TT_NUMBER) {
        System.out.println(i);
        array[i++] = (int) str.nval;
    }
}