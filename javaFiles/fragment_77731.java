this.button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        filePath = new String(textArea.getText());

        if(filePath == null){
            System.out.println("String is null.");
        }
        else
        {
            System.out.println(filePath);
        }

        dispose();
    }
});