public static void main(String[] args) {
    int i;
    int size;

    Scanner read = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    size = read.nextInt();
    int array[] = new int[size];//Set the size of the array when you definetely know it
    System.out.print("Enter Array Numbers : ");
    for (i = 0; i < size; i++) {
        array[i] = read.nextInt();
    }
    for(int j = size-1; j >= 0; j--){
        System.out.println(array[j]);
    }

}