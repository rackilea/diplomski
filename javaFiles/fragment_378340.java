//get your file read and into an array of strings or something similar
Map<String,Field> fieldmap = new Hashmap
Constructor constructor = clientconfig.getConstructor
ClientConfig objectinstance = constructor.inkvoke(//fill in every argument with null here)
//put all the pairs in the fieldmap
for(String fieldname://insert first line of file here){
fieldmap.put(fieldname,Field)
}

//for each field in the object, retrieve the feild value from the feildmap and set it 
//in the object using the matching name
for(Field field:objectinstance){
    field.set(objectinstance,fieldmap.get(field.getName))
}