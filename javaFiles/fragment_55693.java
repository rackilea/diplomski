private void printHistogram(int[] array) {
     for (int range = 0; range < array.length; range++) {
        String label = range + " : ";
        System.out.println(label + convertToStars(array[range]));
    }
}

private String convertToStars(int num) {
    StringBuilder builder = new StringBuilder();
    for (int j = 0; j < num; j++) {
        builder.append('*');
    }
    return builder.toString();
}