static void print(int size) {
    if (size == 0) {
        System.out.println();
    } else {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();

        print(size / 2);

        //when stack ends point of execution will go to next statement
        //(stack ends when size==0, after that will be performed  size==1, and size=2, size== 5, eop)
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}