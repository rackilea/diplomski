//if the data is an integer represented as String 
    String intAsString = "5";
    //convert it. catch NumberFormatException exceptions 
    int intValue = Integer.parseInt(intAsString);
    //update 
    pst.setInt(3, intValue);