public void swap(int []numbers,int i,int min) {
    int temp;
    temp = numbers[i];
    numbers[i] = numbers[min];
    numbers[min]=temp;
}