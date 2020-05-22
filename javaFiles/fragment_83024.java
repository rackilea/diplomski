while (loop == true) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String in = a;
        info("User input: " + in, "DEBUG", 0);
        if ("kill".equals(in)) {
            info("Are you sure you would like to kill the running instance? [Y/N]", "CONSOLE", 0);
            if ("Y".equals(in) || "y".equals(in)) {
                info("Starting KILL method.", "CONSOLE", 0);
                s.close();
                loop = false
            } else if ("N".equals(in) || "n".equals(in)) {
                info("Cancelled.", "CONSOLE", 0);
            } else {
                info("Illegal arguements given. Cancelled.", "CONSOLE", 0);
            }

        } else {
            info("Illegal Arguements given.", "CONSOLE", 0);
        }

    }