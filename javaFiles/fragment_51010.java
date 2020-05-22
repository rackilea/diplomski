...
    set = pre.executeQuery();
    if (!set.isBeforeFirst()){
        JOptionPane.showMessageDialog(null, "The record was not found.");
    }
    else{
        ResultSetMetaData meta = set.getMetaData();
        int totalcolumn=meta.getColumnCount();
        while(set.next()){
            for(int i=1;i<=totalcolumn;i++){
                System.out.printf("%-8s\t", set.getObject(i));
            }
            System.out.println();           
        }
    }
}
catch(Exception e1){
...