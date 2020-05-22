public void display(){
    for(int x=0; x<fieldRecords.length; x++)
        System.out.println(fieldRecords[x]);
}


public void load(){
    for(int x=0; x<vol1HH.length; x++)
        vol1HH.setText(fieldRecords[x]);
}