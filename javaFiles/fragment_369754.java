class buttonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            myMainWindow.setEnabled(false);
            mcveF2 f2 = new mcveF2(mcveF1.this);
            f2.runGUI();
        }
    }