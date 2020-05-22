//Addition
          do
            {
                System.out.println("You Choose Addition\n\n\n");
                System.out.println("Input the first number:\n");
                x = Double.parseDouble(input.nextLine());//read the whole line, then parse into double
                System.out.println("Input the second number:\n");
                y = Double.parseDouble(input.nextLine());//read the whole line, then parse into double
                operation = x + y;
                System.out.println("The sum is :" + operation);

                System.out.println("Continue?");
                System.out.println("Y/N");
                getChar = input.nextLine();//when not reading the whole line, getChar is empty
            }
            while (getChar.equals("Y"));