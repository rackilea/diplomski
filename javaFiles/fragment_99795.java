AcroFields fields = stamper.getAcroFields();
Map<String, AcroFields.Item> fields = acroFields.getFields();
Iterator<Entry<String,Item>> it = fields.entrySet().iterator();

//iterate over form fields
while(it.hasNext()){
    Entry<String,Item> entry = it.next();

    float[] position = acroFields.getFieldPositions(entry.getKey());
    int pageNumber = (int) position[0];
    float lowerLeftX = position[1]; 
    float lowerLeftY = position[2];
    float upperRightX = position[3];
    float upperRightY = position[4];

    float fieldLength = Math.abs(upperRightX-lowerLeftX)
}