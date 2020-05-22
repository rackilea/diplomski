btAdd2.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){
        int x[]=list2.getSelectedIndices();
        for(int i=0;i<x.length;i++){
            dlm1.add(i,dlm2.get(x[i]));
        }
    }       
});