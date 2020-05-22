do {
        System.out.println("Are you happy or sad today?");
        reply = scan.nextLine(); // Waits for input
        if (reply.equalsIgnoreCase("Happy")) {
            emotion = true;
        } else {
            emotion = false;
        }
    } while (!(reply.equalsIgnoreCase("happy") || reply.equalsIgnoreCase("sad")));

    do {
        System.out.println("Are you short or tall?");
        reply2 = scan.nextLine();
        if (reply.equalsIgnoreCase("Tall")) {
            height = true;
        } else {
            height = false;
        }
    } while (!(reply2.equalsIgnoreCase("short") || reply2.equalsIgnoreCase("tall")));

    do {
        System.out.println("Are you strong or weak");
        reply3 = scan.nextLine();
        if (reply.equalsIgnoreCase("Strong")) {
            strength = true;
        } else {
            strength = false;
        }
    } while (!(reply3.equalsIgnoreCase("strong") || reply3.equalsIgnoreCase("weak")))