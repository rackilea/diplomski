private class optionAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == onTop)  //onTop is a menuItem
            setAlwaysOnTop(true); //This does not work of course just to demonstrate you what I want to do
        }
    }