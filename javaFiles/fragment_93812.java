public void paintComponent(Graphics g){
    super.paintComponent(g);

    int teller;

    g.setColor(Color.RED);  //flowerpot
    g.fillRect(300, 350, 500, 100);


    int x = 1;
    for (teller=1; teller <= amount ;teller++) { 

        //Flower 1
    g.setColor(Color.GREEN);  //stem
    g.fillRect(320 + x, 250, 10, 100);


    g.setColor(Color.PINK); //petals
    g.fillOval(304 + x, 190, 40, 40);
    g.fillOval(330 + x, 210, 40, 40);
    g.fillOval(320 + x, 240, 40, 40);
    g.fillOval(290 + x, 240, 40, 40);
    g.fillOval(280 + x, 210, 40, 40);

    g.setColor(Color.YELLOW);  //pistil
    g.fillOval(312 + x, 225, 25, 25);

     x = teller * 80;  
          //<---- here we are multiplying with the teller a fixed amount 


    }


}