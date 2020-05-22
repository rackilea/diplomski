try
            {
                String answer = JOptionPane.showInputDialog(null, "What's my type\n\n\n1) String\n2) integer\n3) double\n4) Quit the program");
                choice = Integer.parseInt(strChoice);

                //test for valid codes 1, 2, 3, or 4
                if (choice<1 || choice>4) throw new NumberFormatException();
                else done = true;
            }
                catch(NumberFormatException e)
            {