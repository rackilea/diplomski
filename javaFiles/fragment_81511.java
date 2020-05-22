final EntityForm ef = new EntityForm();
ef.getOkayButton().addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {

        String text = ef.getTextInput().getText();
        // draw text code here...

    }
});
ef.setVisible(true);