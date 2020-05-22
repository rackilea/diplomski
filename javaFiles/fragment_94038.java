public static void birdInput() {
        int i = 0;
        while (i <= birds.length) {
            System.out.println("What bird did you see?");
            birds[i] = inputCheck();
            System.out.println("How many did you see?");
            numbers[i] = Integer.parseInt(inputCheck()); //you should check here if its actuall a number otherwiese your programm will crash 
            i++;

        }
    }