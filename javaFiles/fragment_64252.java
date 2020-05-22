for (int i = 0; sum < total && i < loop; i++) {
    sum += array[i];
    System.out.print(String.valueOf(array[i]) + " ");
    if (sum < total) {
        sum+=array[n-1-i];
        System.out.print(String.valueOf(array[n-1-i]) + " ");
    }
}