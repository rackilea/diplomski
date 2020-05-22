long alarmcal = new Date().getTime() + 10 * 1000; // add 10 seconds from current time
    while (true) {
        try {
            Thread.sleep(2000);
            System.out.println(alarmcal + " " + new Date().getTime());              
            if (alarmcal >= new Date().getTime()) {
                System.out.println("This note has a reminder scheduled.");
            } else {
                System.out.println("Reminder date passed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }