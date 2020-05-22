System.out.print("Enter a weight:\t");
            weighte = type.nextDouble();

            if (weighte > 13)
                System.out.println("Too Big of a Package!");

            else if (weighte == 13)
                System.out.println("price = $3.62");

            else if (weighte >= 12)
                System.out.println("price = $3.40");

            else if (weighte >= 11)
                System.out.println("price = $3.18");

            else if (weighte >= 10)
                System.out.println("price = $2.96");

            else if (weighte >= 9)
                System.out.println("price = $2.74");

            else if (weighte >= 8)
                System.out.println("price = $2.52");

            else if (weighte >= 7)
                System.out.println("price = $2.30");

            else if (weighte >= 6)
                System.out.println("price = $2.08");

            else if (weighte >= 5)
                System.out.println("price = $1.86");

            else if (weighte >= 4)
                System.out.println("price = $1.64");

            else if (weighte >= 3)
                System.out.println("price = $1.42");

            else if (weighte >= 2)
                System.out.println("price = $1.20");

            else if (weighte >= 1)
                System.out.println("price = $.98");

            else if (weighte < 1)
                System.out.println("Package is too small!");

            else
                System.out.println("Not a valid Package!");