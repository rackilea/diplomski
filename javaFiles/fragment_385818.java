for (int i = 0; i < array.length; i++) {
    max = Math.max(max, array[i]);
}
for (int i = 0; i < array.length; i++) {
    if (array[i] == max) {
        System.out.println(i);
    }
}