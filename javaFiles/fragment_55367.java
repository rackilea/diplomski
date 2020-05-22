b1.addActionListener(new ActionListener (){
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultListModel Model1 = new DefaultListModel();
        for(int i = 0; i < Array1.length; i++){
            Model1.addElement(Array1[i]);
        }
        list.setModel(Model1);
    }
});

b2.addActionListener(new ActionListener (){
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultListModel Model2 = new DefaultListModel();
        for (String Array21 : Array2) {
            Model2.addElement(Array21);
        }
        list.setModel(Model2);
    }
});