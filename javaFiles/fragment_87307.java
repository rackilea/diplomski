String keyStr = parts[0].replaceAll("\"","").trim(); //Now, key = key: onGapLeft
String valueStr = parts[1].replaceAll("\"","").trim();//Now, value = value : moveLeft

//Then, you split `key: onGapLeft` with character `:`
String key = keyStr.split(":")[1].trim();

//And the same for `value : moveLeft` : 
String value = valueStr.split(":")[1].trim();