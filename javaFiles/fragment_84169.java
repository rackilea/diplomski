for (i = 0; i < maxRow; i++) {
        for (j = 0; j < maxCol; j++) {
            System.out.print("Please enter ");
            int number = input.nextInt();
            boolean isItOk = false;
            while (isItOk == false) {
                if (number < 0 || number > 100) {
                    System.out.println("You shall not insert a value below 0 or bigger than 100! Try it again");
                    number = input.nextInt();
                } else {
                    isItOk = true;
                }
            }
            mark[i][j] = number;
        }
    }