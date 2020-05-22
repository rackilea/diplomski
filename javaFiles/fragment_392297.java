int[] cw_Mark = new int[6];
    for (int i = 0; i < cw_Mark.length; i++) {
        System.out.println("Please Enter Your Module " + (i + 1) + " Coursework Mark: ");
        while (true) {
            String next = input.next();
            try {
                cw_Mark[i] = Integer.parseInt(next);
                if (i >= 0 || i <= 100) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Please Enter a Number Between 1 and 100");
        }
    }