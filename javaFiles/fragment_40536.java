public ResizeToTextButton(String txt){
    super(txt);
    addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            setText(JOptionPane.showInputDialog("Text"));
        }
    });
}