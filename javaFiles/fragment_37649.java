JSONSerializer ser = new JSONSerializer();
// Exclude these standard fields from childs
ser.exclude(
    "*.persistent", 
    "*.class",
    "*.entityId"
);
// Include childs and all its other fields
ser.include(
    "childs",
    "childs.*"
);
// Exclude everything else
ser.exclude("*"); 
String data = ser.serialize(parent);