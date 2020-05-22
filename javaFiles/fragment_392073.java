//iterate the list
    for(String line : list){
        String[] columns = line.split(",");
        for(int i =0; i<columns.length; i++)
             System.out.println("column "+ i +": "+columns[i]);
    }