public static void main(String[] args) {

    Scanner x = new Scanner(System.in);
    int w;
    int h;

    System.out.print("Enter the Width ");
    w = x.nextInt();
    System.out.print("Enter the height ");
    h = x.nextInt();

    for (int i = 0; i < h; i++) {

        for (int j = 0; j < w; j++) {

            if(i % 2 == 0){
                System.out.print("*");
            }else{
                System.out.print("+");
            }

        }
        System.out.println();
    }
}