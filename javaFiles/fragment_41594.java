push.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Push")){
            state.handlePush(SP.this);  // *this* now refers to SP
        }
    }
});