something like

try {
    String val = tablePaxModel.getValueAt(currentRow, currentCol).toString();

    int temp=0;
    if(val.isEmpty() || val == null)
       temp=0;

    else
    {
    temp = Integer.parseInt(val);
    }

    total = total + temp
}

catch (Exception e) 
    {
        e.printStackTrace();  
    }