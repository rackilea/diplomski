String s = "ABC_DEF-HIJ (KL MNOP_QRS)";
String[] splits = s.split("-");  // {"ABC_DEF", "HIJ (KL MNOP_QRS)"}

String[] lefts = split[0].split("[^a-zA-Z]");  // {"ABC", "DEF"}
String[] rights = split[1].split("[^a-zA-Z]"); // {"HIJ", "", "KL", "MNOP", "QRS"}

String string1 = lefts[lefts.length - 1]; // "DEF""
String string2 = rights[0];               // "HIJ"