class SomeObject { // This class contains all the details a row in an excel can contain}

Map<String, List<SomeObject>> myMap = new HashMap<String, List<SomeObject>>(); // Create your hashmap

For every row read from the excel using POI {
    1. Create a new SomeObject with the data read from the row
        a. if the firstname value already exists in myMap, then add this new object to the already existing list for that key
        b. if not present, create a new arraylist, add this element and put a new entry in map with firstname and list
    2. continue this, till there are more rows to be read.
}