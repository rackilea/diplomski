List<DataObject> objects = new ArrayList<>();
DataObject dataObject = null;
for(String s : lines) {
    String [] splitLine = s.split(",");
    if(splitLine[0].matches("(\d{2}\/){2}\d{4}")) {
        // We found a data
        if(dataObject != null && splitLine.length == 2) {
            String date = splitLine[0];
            String dish = splitLine[1];
            dataObject.add(date, dish);
        } else {
            // Handle error
        }
    } else if(splitLine.length == 2) {
        // We can create a new data object
        if(dataObject != null) {
            objects.add(dataObject);
        }
        String name = splitLine[0];
        String id = splitLine[1];
        dataObject = new DataObject(name, id);
    } else {
        // Handle error
    }
}