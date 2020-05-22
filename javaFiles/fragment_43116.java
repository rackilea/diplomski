if (input.equals("yes") || input.equals("y") || input.equals("Y") || input.equals("YES") || input.equals("Yes"))
            {
                System.out.println("");
                break;

            }
            else if (input.equals("no") || input.equals("No") || input.equals("NO") || input.equals("n") || input.equals("N"))
            {
                System.out.println("Your select courses are as follows");
                for (int x = 0; x < i + 1; x++)
                {
                    System.out.println("");
                    System.out.println((x + 1) + ": " + course[x]);
                }
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid input!! Please try again.");
                j--;
            }