JsonArray myArray = new JsonArray(jsonString);
int length = myArray.length();
for(int i=0; i<length; i++){
     myArray.get(i) 
//note this returns an object of type object, 
//use other get functions to get other types

}