public void mouseClicked(java.awt.event.MouseEvent e) {

        String index = ((JLabel)e.getSource()).getText().substring(xx,yy); // here xx , yy  depend on how you are naming jlables .this should return 2 if your lable is lbl2
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "card" + index);
        System.out.println("card" + index);
}