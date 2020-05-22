public void paintComponent(Graphics g){
    if(test == true){
        sp = new SecondPanel();
        removeAll();
        revalidate();
        setContentPane(sp);
    }
}