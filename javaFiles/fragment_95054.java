JButton btn = new JButton();
btn.addActionListener(new ActionListener(){
    public void onActionPerformed(ActionEcent event){
         JButton btn = (JButton)event.getSource();
    }
});