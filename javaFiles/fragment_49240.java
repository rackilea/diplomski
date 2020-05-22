public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("button")) {

            String str = e.getActionCommand().replaceAll("button", "");
            System.out.println(str);
            String[] v = str.split("_");
            int i = Integer.parseInt(v[0]);
            int j = Integer.parseInt(v[1]);
            /*
            int i = Integer.parseInt(Character.toString(e.getActionCommand()
                    .replaceAll("button", "").replaceAll("_", "").charAt(0)));
            int j = Integer.parseInt(Character.toString(e.getActionCommand()
                    .replaceAll("button", "").replaceAll("_", "").charAt(1)));
             */

            intArray[i][j]++;
            // buttons[i][j].setVisible(false);

            buttons[i][j].setBackground(Color.black);

            System.out.println(e.getActionCommand() + "  " + i + "  " + j);
        }
        // score2();
    }