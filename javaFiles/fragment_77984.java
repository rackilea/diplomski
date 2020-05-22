if (beu == third) {
        for (int m = 0; m < 6; m++) {
            String stars = "";
            for (int k = 6; k >= m; k--) {
                System.out.print(" ");
                stars += " ";
            }
            for (int i = 1; i <= m; i++) {
                System.out.print("*");
                stars += "*";

            }
            je.setText(stars);
            aslist.addElement(je.getText());
            asterisk.setModel(aslist);

            System.out.println();
        }
    }