public static void main(String[] args) {
        System.out.println("Would you like to enter an integer");
        Scanner s = new Scanner(System.in);
        String ans;
        int odd = 0, even = 0, num;
        boolean b = true;
        while (b) {
            ans = s.next();
            if (ans.equalsIgnoreCase("yes")) {
                System.out.println("Please enter an integer");
                num = s.nextInt();
                if (num % 2 == 0) {
                    even++;
                } else if (num % 1 == 0) {
                    odd++;
                }
                System.out.println("Do you have another integer to enter");
            } else {
                b = false;
            }
        }
        System.out.println("Odd: " + odd + " Even: " + even);
    }