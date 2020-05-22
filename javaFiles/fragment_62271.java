public void actionPerformed(ActionEvent e)
    {               
        if(e.getSource() == btnClear)
        {
            System.out.println("Clearing");
            sG = new SortsGui(); // You are creating a new instance of SortsGui
            sG.clearTextBoxes(); //You are calling the method on this new instance
        }
    }