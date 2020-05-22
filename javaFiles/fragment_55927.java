else if (choice.equalsIgnoreCase("Remove")) {
                System.out.println("Enter the character to remove");
                String ridOf2 = input.nextLine();
                String charRemove = String.valueOf(ridOf2.charAt(0));
                userStr = userStr.replaceAll(charRemove, "");//This will replace the first char the enter with nothing
            }