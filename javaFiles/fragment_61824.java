public try2(ArrayList<Integer> test) {
        for (int x = 0; x <= test.size()-1; x++) {
            try {
                if (test.get(x) < 0 || test.get(x) > 100) {
                    throw new IllegalArgumentException();
                } else {
                    this.userInput = test;
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, " NO NEGETIVES ALLOWED ");
            }
        }
    }