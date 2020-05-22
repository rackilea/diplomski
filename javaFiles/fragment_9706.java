Scanner in=new Scanner(System.in);
            String[] eq=in.nextLine().split(" "); // use nextLine() instead of next().

            double a=Double.parseDouble(eq[0]);// 1st operand
            double b=Double.parseDouble(eq[2]);// 3rd operand

            if(eq[1].equals("+")){ //operator // compare string with equals method not with (==).
                System.out.println(">>"+String.valueOf(a+b));
            }else if(eq[1].equals("-")){
                System.out.println(">>"+String.valueOf(a-b));
            }else if(eq[1].equals("/")){
                System.out.println(">>"+String.valueOf(a/b));
            }else if(eq[1].equals("*")){
                System.out.println(">>"+String.valueOf(a*b));
            }