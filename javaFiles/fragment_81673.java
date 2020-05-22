`public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cont = "y";
        String more = null;


        do {

            try{
                System.out.println("Welcome to the Pythagorean Theorm Program!!");
                System.out.println("");
                System.out.println("Choose one of the following:");
                System.out.println("");
                System.out.println("1. A2 + B2 = X");
                System.out.println("2. A2 + X = C2");
                System.out.println("3. X + B2 = C2");

                int choice = input.nextInt();

                switch (choice) {

                    case 1: case1();
                            break;
                    case 2: case2();
                            break;
                    case 3: case3();
                            break;
                }
            }
            catch(Exception e) {
                System.out.println("error");
            }

            System.out.println("Do you want to continue?");
            more = input.next();
        } while (more.equals(cont));



    }`