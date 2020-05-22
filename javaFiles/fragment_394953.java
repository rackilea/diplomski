button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
        vp = new MyPanel();
        vp.revalidate();
    }
});