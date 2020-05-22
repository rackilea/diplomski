System.out.print("Enter a weight:\t");
            weightl = type.nextDouble();

            if (weightl > 3.5)
                System.out.println("Too Big of a Package!");

            else if (weightl == 3.5)
                System.out.println("price = $1.15");

            else if (weightl >= 3)
                System.out.println("price = $.93");

            else if (weightl >= 2)
                System.out.println("price = $.71");

            else if (weightl >= 1)
                System.out.println("price = $.71");

            else if (weightl < 1)
                System.out.println("Package is too small!");
        }