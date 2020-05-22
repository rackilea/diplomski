buusun.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent arg0)
        {
            tf.setText(text.getText().substring(0, text.getText().length() - 1)); 
        }

    });