final SP thisSp = this;
push.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Push")){
            state.handlePush(thisSp);  // same as using SP.this
        }
    }
});