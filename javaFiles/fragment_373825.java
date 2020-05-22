private double parseDouble(String val){
    if(val== null || val.isEmpty()) 
        return 0.0;
    else
        return Double.parseDouble(val);
}