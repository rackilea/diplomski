Map<String,Integer> map=new HashMap<>();
    //Open the file for reading using some excel API

    //Read the unit and quantity line by line and assign them in `unit` and `quantity` variables
    String unit="";          // Read actual unit value from file
    int quantity=0;          // Read actual quantity value from file

    if(map.containsKey(unit)){
        map.put(unit, map.get(unit)+quantity);
    }