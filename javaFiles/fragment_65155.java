boolean b = false;
        do {
            try {
                System.out.print("Are you above 18?");
                Scanner n = new Scanner(System.in);
                boolean bn = n.nextBoolean();
                if (bn == true) {
                    System.out.println("Over 18");
                } else if (bn == false) {
                    System.out.println("under 18");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
        } while (!b);