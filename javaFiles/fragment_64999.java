public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof MyButton) {
        MyButton btn = (MyButton)e.getSource();
        String ftnName = this.getLinkedFtn(btn.getName());
        if(!ftnName.equals("")){
            this.callFtn(ftnName);
        } else {
            System.out.println("unknown ftnName");
        }
    } else {
        System.out.println("unknown source");
    }
}