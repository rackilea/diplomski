int row = 0;
        int column = 0;

        Scanner input = new Scanner(System.in);
        boolean nonValid = true; //if nonvalid is true the user input is wrong
        while (nonValid) { // keep asking user for input until it is according to your requirements
            System.out.print("Please enter an integer (row) greater than 0 and less than 15: ");
            row = input.nextInt();
            System.out.print("Please enter an integer (column) greater than 0 and less than 15: ");
            column = input.nextInt();
            if (row > 0 && row < 15 && column > 0 && column < 15) {//check user input here if it is good change nonValid to false to exit loop
                nonValid = false;
            } else {
                System.out.println("Bad Input try again!");
            }
        }
        for (int i = 0; i < row; i++) {//this loops rows
            for (int j = 0; j < column; j++) {//this loops columns
                System.out.print("O");//use print as you need each "O" next to each other in a row
            }//
            System.out.println("O");//after each row is printed use println(new line) to move to next line
        }