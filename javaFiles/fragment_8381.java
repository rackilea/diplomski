JButton btnShowCart = new JButton("Show cart");
    btnShowCart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

            String content = "";
            for (int i = 0; i < listWithItems.size(); i++) {
                content += listWithItems.get(i)  + "\n" ;     
            }
            txtBasket.setText(content);
        }
    });