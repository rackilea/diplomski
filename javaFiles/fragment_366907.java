Integer[] validateLength = {8,2,22,11,25,13,6,2,34,11,35,35,34,11,1};

    public String validate(String value, int index){
    // Check to see if the cell is null or blank
    if (StringUtils.isNullOrBlank(value)) {
        return "EMPTY";
    } else if (value.length() > validateLength[index]) { 
        return "TOOBIG";
      }
      else {
        return "OK";
      }
  }