switch(x) {
            case 1:
                System.out.println("Please enter function");
                Scanner scan = new Scanner(System.in);
                String functionHeader = scan.nextLine();
                getName(functionHeader);
            case 2:
                System.out.println("it worked!");
            case 3:
                System.exit(0);
       }