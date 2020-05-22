push.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Push")){
            state.handlePush(this);  // *this* refers to anonymous inner-class ActionListener 
        }
    }
});