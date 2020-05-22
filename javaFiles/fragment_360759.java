public static void main(String[] args) {
        System.out.println("-----Pyramid------");
        String word = "Stream";
        int n = word.length();
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j <= n - i; j++)
                System.out.print(" ");
            for (int k = 0; k < i - 1; k++)
                System.out.print(word.charAt(k) + " ");
            System.out.print("\n");
        }
    }