Timer t = new Timer(500, new ActionListener() {
    boolean selected = false; 

    @Override
    public void actionPerformed(ActionEvent e) {
        selected = !selected;
        for(int i=0; i<yourList.size(); i++) {
            yourList.get(i).setSelected(selected);
        }
    }
});
t.start();