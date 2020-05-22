public SimonGame1() {
     //....

     rand = new SecureRandom();
     labelTop = new JLabel( "" );

     //initialize with 3
     for(int i = 0; i < 3; i++)
     {
         randomLetters += getRandomLetter();
     } 
     labelTop.setText( randomLetters );

     //...

     add(labelTop, BorderLayout.NORTH);

}