String line = reader.readLine();
String[] array = line.split(" ")// use same delimiter used to write
if(array.lenght() ==3){ // to check if data has all three parameter 
    people.add(new Person(array[0], array[1], Double.parseDouble(array[2]))); 
    // you have to handle case if Double.parseDouble(array[2]) throws exception
}