case 1:
                System.out.println("Please enter function");
                Scanner scan = new Scanner(System.in);
                String functionHeader = scan.nextLine();
                getName(functionHeader);
                break;
            case 2:
                System.out.println("it worked!");
                break;
            case 3:
                System.exit(0);
                break; //This one is technically unnecessary because it's the final case label.