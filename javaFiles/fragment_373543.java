String nS = sc.nextLine();
    System.out.print(nS);

    for (Part y : thelist) {
        if (nS.equals(y.getName())) {
            System.out.println("Please enter replenish quantity");
            int qty = sc.nextInt();
            sc.nextLine();
            y.replenish(qty);
            System.out.println("Complete");
        }
    }