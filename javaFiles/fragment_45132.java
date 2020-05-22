// inner class avoids anonymous inner class, for clarity

    class ButtonListener implements ActionListener // simulates click of logical form button
    {
        public void actionPerformed( ActionEvent bp )
        {    
          txaOutput.selectAll();
          txtPattern.grabFocus();
          txtPattern.select(0, 99);
        } 
    }