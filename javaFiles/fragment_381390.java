for (int i = 0; i < array.length; i++) {
    sum += array[i];
    if (i > 0 && (i + 1) % 3 == 0) {
        System.out.println(sum);
        sum = 0;
    }
}