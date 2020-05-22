CsvWriter writer = new CsvWriter(outputWriter, settings){
    @Override
    protected void processRow(Object[] row) {
        for(int i = 0; i < row.length; i++){
            Object value = row[i];
            appender.append(value.toString());
            if(i + 1 < row.length) { //not the last column
                appender.append(',');
            }
            appendValueToRow();
        }
    }
};