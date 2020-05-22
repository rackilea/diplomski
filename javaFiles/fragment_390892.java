while(strToken.hasMoreElements()){
        rows=new Vector();
        for(int i=0; i<column.length; i++){
            rows.add(strToken.nextElement()); //Exception will throw on this line
        }
        ViewTablePanel.tblModel.addRow(rows);
    }