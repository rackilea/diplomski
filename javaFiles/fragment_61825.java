public static void main(String[] args) {
        testnum =
                Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Please Enter The Amount Of Test To Be Calculated Below "));
        classes();
    }

    public static void classes() {
        int userInput = 0;
        if (userInput == JOptionPane.YES_OPTION) {
            user = new ArrayList<Integer>();
            for (int count = 1; count <= testnum; count++) {
                String userInputString =
                        JOptionPane.showInputDialog(null, " PLEASE ENTER ALL THE FOLLOWING TEST GRADES TO CALCULATE ");
                int value = Integer.parseInt(userInputString);
                user.add(value);
            }

            if (userInput == JOptionPane.NO_OPTION) {
                testing.setAvg();
                JOptionPane.showMessageDialog(null, "You average is" + (testing.getAvg()));
            }

            new try2(user);

        }
    }