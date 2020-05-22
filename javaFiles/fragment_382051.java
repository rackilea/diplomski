...

try{
    for(List<String> row: model.getAllFabrics()){
        tableModel.addRow(row.toArray(new String[row.size()]);
    }
...