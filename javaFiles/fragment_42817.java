public static String getColorByAbbreviation(String abbreviation){
    for(Motorcycle m : Motorcycle.values()){
        if(m.getAbbreviation().equals(abbreviation)){
            return m.getColor();
        }
    }
    return "";
}