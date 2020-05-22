if(i==1){
                JLabel picSecond = new JLabel(new ImageIcon("Bomber.jpg"));//<--Fact is I dont want to create another JLabel, I want to modify the pic location content in JLabel pic.
                picSecond.setSize(100, 100);

                panel.add(picSecond);
            }
            label.setText("Time: "+i);