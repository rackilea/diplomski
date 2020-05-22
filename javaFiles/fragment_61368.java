for (int i=0; i<bc.length; i++) {
  String matchingKey = null;
  while (e1.hasMoreElements()) {
    key = (String) e1.nextElement();
    if (testcases.equals(key)) {
      matchingKey = key;
      break;
    }
  } 
  if (matchingKey != null) {
    ... IN ...

  } else {   
   ... OUT ...