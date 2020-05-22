public void setBounds(int x,int y,int width,int height) { 
    super.setBounds(x,y,width,height);
    if (panel1 != null) {
       panel1.setBounds(4,6,this.getSize().width-8,this.getSize().height-12);
    }
}