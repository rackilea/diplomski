public boolean isDone() {

    ArrayList<String> al = new ArrayList<String>();

    al.add(d1.getText());
    al.add(d2.getText());   
    al.add(d3.getText());    
    al.add(d4.getText());   
    al.add(d5.getText()); 

    for (String str : al)
        if (str != null && str.contains("."))
            return false;

    return true;

}