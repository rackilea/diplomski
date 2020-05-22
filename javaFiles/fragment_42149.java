final JTextArea textArea = new JTextArea(Long.ToString(System.currentTimeMillis())); 
JButton newButton2 = new JButton("Update time");
newButton2.addActionListener(new ActionListener(){
     @Override
        public void actionPerformed(final ActionEvent e) {    
          textArea.setText(Long.toString(System.currentTimeMillis()));    
        }
});