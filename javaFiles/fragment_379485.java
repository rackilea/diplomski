public void setValueAt(Object arg0, int arg1, int arg2) {

    if (arg2 == 0) {                 
        boolean checked = (Boolean)arg0;

        if(checked){
            //Handle if user checked a box.

            //Iterate through all rows
            for(int i = 0; i < getRowCount();i++){
                boolean isSelected = dataList.get(i).getSelected();

                if(isSelected != (i == arg1)){
                    dataList.get(i).setSelected(i == arg1);
                    fireTableCellUpdated(i, 0);
                }
            }
        }else{
            //Handle if user unchecks the box.
        }              
    }else if(!(dataList.set(arg1, arg0).equals(arg0))){
        fireTableCellUpdated(arg1, arg2);
    }
}