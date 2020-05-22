String inCondition = "";
boolean first = true;
ArrayList<String> categories = checkNo();

for(String cat : categories){
    if(first){
        first = false;
    } else {
        inCondition += ",";
    }
    inCondition += cat;
}

String sqlSearch = "SELECT * from Item where category in (" + inCondition + ")";