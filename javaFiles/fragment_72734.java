public String calculateHours (){
    double sum = 0;
    if(hourArray != null){ // hourArray might be null
        double hour = 0;
        for (int i = 0; i < hourArray.length; i++) { // use .length here
            // check for nulls and empty String
            if (hourArray[i] != null && hourArray[i].getText() != null 
                                     && !"".equals(hourArray[i].getText())) {
                try{ // the text might can not be parsed to a double
                    hour = Double.parseDouble(hourArray[i].getText());
                }catch(NumberFormatException ex){
                    hour = 0;
                }
            }
            else  {
                hour = 0;
            }
            sum += hour; // I guess you want that inside your loop
        }
    }
    return String.format("%.2f", sum);
}