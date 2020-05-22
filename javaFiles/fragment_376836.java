for(int i = 1; i <= word.length(); i++)
                {

                    Buttons[i] = new JButton();
                    Buttons[i].setPreferredSize(new Dimension(80, 80));

                    Buttons[i].setText(word.charAt(i-1) + ""); 
                    second.add(Buttons[i]);
                    second.add(Box.createHorizontalStrut(20));

                }