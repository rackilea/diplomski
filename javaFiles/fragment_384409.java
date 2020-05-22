btnEncrypt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

            for (int i = 0; i < passWord.length(); i++) {
                int temp = 0;
                temp = (int) passWord.charAt(i);
                temp = temp * 9834 / 8942 / 33 * 90023243 * 9 + 124324534 - 2335;
                passWord.setCharAt(i, (char) temp);

            }
            textField_1.setText(passWord.toString());

        }
    });