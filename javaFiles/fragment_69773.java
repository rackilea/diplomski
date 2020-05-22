btAdd1.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){
        int x[]=list1.getSelectedIndices();
        for(int i=0;i<x.length;i++){
            dlm2.add(i,dlm1.get(x[i]));
        }
    }       
});