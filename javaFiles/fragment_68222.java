void changeMainColor(Color c){
    this.mainColor = c;
    for (JComponents jc : this.myComponentsList){
        jc.setForeground(c);
        jc.setBackground(c);
    }
}