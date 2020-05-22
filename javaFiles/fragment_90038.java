do {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("(" + (i + 1) + ")" + list.get(i));
        }
        System.out.println(" ");

        try {
            option = sc.nextInt();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            sc.next();
            continue;
        } catch (InputMismatchException e) {
            System.out.println("Option input mismatch.");
            sc.next();
            continue;
        }
        sc.nextLine();
        if (option == 1) {
            System.out.print("Enter name: ");
            // scanner takes in input
        } else if (option == 2) {
            System.out.print("Enter desc: ");
            // scanner takes in input
        }
        try {
            type = list.get((option - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            option=3;
        }
    } while (option <= 0 || option >= 3);