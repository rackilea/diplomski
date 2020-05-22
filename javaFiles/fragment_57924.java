public class Roll {

    DrawingKit dk = new DrawingKit("My Dice");

    Graphics die1 = new Graphics(0,45);
    Graphics die2 = new Graphics(100,45);
    Graphics die3 = new Graphics(200,45);
    Graphics die4 = new Graphics(300,45);
    Graphics die5 = new Graphics(400,45);    

    public static void main(String [] args ){

        JPanel topPanel = new JPanel ();
        JButton button1 = new JButton("Roll");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                // Roll and draws the dices

                rollDices();
                drawDices();

            }
        });


        topPanel.add(button1);
        dk.addPanel(topPanel);

    }

    public static void rollDices() {

        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();

    }

    public static void rollDices() {

        die1.draw(dk);
        die2.draw(dk);
        die3.draw(dk);
        die4.draw(dk);
        die5.draw(dk);

    }

}