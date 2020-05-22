private void displayColumns(Column ...columns){

    for(Column column : columns){

        //System.out.println(column.getName());

        for (String[] line : dataList) {    

            System.out.println( line[column.ordinal()]);    

        }
    }
}