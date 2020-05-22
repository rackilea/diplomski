public void start(String menu){
                switch (menu) {
                    case "yes":
                        jTextArea1.setText(null);
                        diceOne = 0;
                        diceTwo = 0;
                        diceThree = 0;
                        diceFour = 0;
                        diceFive = 0;
                        System.out.println("Rolling...");
                        Game();

                        break;
                    case "no":
                        System.out.println("Goodbye...");
                        System.exit(0);

                        break;
                    default:
                        invalidInput();

                        break;
                }
}