if (args.length != 2) {
        System.out.println("Please enter: java sheet12t1 projectCategory serviceType");
        System.exit(1);
    }

    int projectCategory = Integer.parseInt(args[0]);
    int keyServiceType = Integer.parseInt(args[1]);