private static final Map<Integer, String> MAP_VALUES = new HashMap<Integer, String>();

  private static Map<Integer, String> getMapValues(Employe employe){
    if(MAP_VALUES.isEmpty()){
      MAP_VALUES.put(0, employe.getEmployeeI());
      MAP_VALUES.put(1, employe.getEmployeeLastName());
      MAP_VALUES.put(2, employe.getEmployeeDivision());
      ....
    }
    return MAP_VALUES;
  }

  public String getValueForEmploye(Employe employe){
    String[] value = ...;
    for(int i = 0; i < value.length; i++){
      value[i] = getMapValues(employe).get(i); 
    }
  }