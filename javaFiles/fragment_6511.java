inputPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING)){
    Dimension dim = new Dimension(inputPanel1.getPreferredSize());
    public Dimension getPreferredSize(){
        return new Dimension(dim);
    }
};