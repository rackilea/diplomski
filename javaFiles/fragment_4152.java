class DrawingSpace extends JPanel
{
    private MyButton[] btn;
    private JLabel lblDisplay;   
    public DrawingSpace(){      
        setPreferredSize(new Dimension(450, 100));
        init();
    }

    private void init(){
        btn = new MyButton[5];
        ButtonHandler bh = new ButtonHandler();
        for(int x=0; x<btn.length; x++){
            btn[x] = new MyButton("Button " + (x+1));
            btn[x].addActionListener(bh);
            add(btn[x]);
        }
        lblDisplay = new JLabel("Watch here..");
        add(lblDisplay);
    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            MyButton myBtn = (MyButton)e.getSource();
            myBtn.setClicks(myBtn.getClicks()+ 1);
            lblDisplay.setText(myBtn.getText() + " was clicked, it has gathered " + myBtn.getClicks() + " so far.");   
        }       
    }
}