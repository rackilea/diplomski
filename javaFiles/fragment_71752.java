Map<String, Integer> variableMap = new HashMap<>();

void setVariable(String variableName, int variableContents){
  variableMap.put(variableName, variableContents);
}

public Integer getVariable(String variableName){
   return variableMap.get(variableName);
}