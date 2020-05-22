if(table.getSelectedRow()!=-1){
    int rowIndex=table.getSelectedRow();
    Object value=table.getModel().getValueAt(rowIndex, 0);
    if(value.equals("lmn")){
        //do nothing
    }else{
        // perform desired operation
    }
}