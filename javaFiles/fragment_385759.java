while (c == 1) {
            try {
                System.out.println("enter a number");
                num = Integer.parseInt(scan.nextLine());
                c=2;
            } catch (Exception e) {
                System.out.println("enter a Number please : ");
            }
        }