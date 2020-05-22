if (beu == second) {
        for (int v = 1; v <= 5; v++) {
            String stars = "";
            for (int j = v; j <= 5; j++) {
                stars += s;
            }
            je.setText(stars);
            System.out.println();
            aslist.addElement(je.getText());
            asterisk.setModel(aslist);
        }
    }