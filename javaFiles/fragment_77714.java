public void endElement(String n, String l, String q) {
        switch(Tags.valueOf(l)) {
            case entry:
                in_entryTag = false;
                MyParsedExampleDataSets.add(DataSet);

                break;             
            case data1:
             in_data1 = false;
             break;      
            case data2:
             in_data2 = false;
             break;              
            case data3:
             in_data3 = false;
             break;              
            case data4:
             in_data4 = false;
             break;              
            case data5:
             in_data5 = false;
             break;              
            case entrys:
                break;
        }
    }