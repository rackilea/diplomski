for (long combo = 0; combo < total; combo++) {
    for (int i = 0; i < array.length; i++) {
        int digit = (int) (combo / div[i] % array[i].length);
        if (i != 0)
            System.out.print(' ');
        System.out.print(array[i][digit]);
    }
    System.out.println();
}