while (!strInfo.equals("q")) {
            if (isInteger(strInfo)) {
                number = Integer.parseInt(strInfo);
                if (number >= 1 && number <= 44) {
                    System.out.println();
                    System.out.println(presidents[number - 1][0] + "President " + presidents[number - 1][1] + presidents[number - 1][2] + presidents[number - 1][3] + presidents[number - 1][4] + "Vice President " + presidents[number - 1][5]);
                    System.out.println();
                    System.out.println("Please enter a number between 1 and 44 to see information or q to quit: ");
                    strInfo = input.nextLine();
                } else {
                    System.out.println();
                    System.out.println("Wrong Input! Please enter number 1-44 or q to quit.");
                    strInfo = input.nextLine();
                }
            } else {
                System.out.println();
                System.out.println("Wrong Input! Please enter number 1-44 or q to quit.");
                strInfo = input.nextLine();
            }
        }
        System.out.println();
        System.out.println("This program has been terminated. Good Bye!");
        System.exit(0);