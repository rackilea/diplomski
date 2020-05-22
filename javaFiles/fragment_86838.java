public static void main(String[] args) {

        int num[] = new int[10];

        Scanner sc = new Scanner(System.in);

        System.out.println("Eneter the 10 integers:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the " + (i + 1) + " number:");
            num[i] = sc.nextInt();
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(num[j]);

        }

        Search obj = new Search(num);
    }


public class Search {

    public Search(int x[]) {
        for (int i = 0; i < 10; i++)
            System.out.println("inside a constructer" + x[i]);

    }

}