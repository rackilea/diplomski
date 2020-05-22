public static void main(String[] args){
    int N;
    System.out.println();
    System.out.print("Enter an integer number: ");
    N = input.nextInt();
    int[] a = new int[N];
    Random generator = new Random();
    for (int i = 0; i < a.length; i++) {
        float n = generator.nextFloat();
        if (n <= 0.4) {
            a[i] = 1;
        } else if (n <= 0.7) {
            a[i] = 3;
        } else if (n <= 0.9) {
            a[i] = 4;
        } else {
            a[i] = 2;
        }
    }
}