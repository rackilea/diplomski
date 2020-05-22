ArrayList<String[]> data = new ArrayList<String[]>();
    addRows(3);
    writer.writeAll(data);

    public void addRows(int rows){
             for(int i=0; i<rows; i++ ){
                  data.add(new String[] {"1", "2", "3", "4", "5", "6"});
             }
        }