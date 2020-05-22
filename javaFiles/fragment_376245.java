// Combo
    cb.addItem("--filler--");

    cb.addActionListener(new ActionListener() {

        public void actionPerformed(final ActionEvent e) {

            cb.removeAllItems();

            for (int i = 1; i < corps.length; i += 2) {
                String tempRes = corps[i];
                System.out.println(tempRes);
                cb.addItem(tempRes);
            }

        }
    });