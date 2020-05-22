String[] values = s.split(";");  
String[] actions = values[0].split(":");
String[] result = new String[actions.length + values.length - 1];
System.arraycopy(actions, 0, result, 0, actions.legnth);
System.arraycopy(values, 1, result, actions.length, values.length - 1);
return result;