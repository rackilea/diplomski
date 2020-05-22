double highestNum = 0.0; // 0 set to the default lowest value
String highestKey = ""; // used to save the key assosciated w/ highest value
for (String key : quantityHash.keySet()) {
    double value = quantityHash.get(key);  // ADDED LINE
    if (value > highestNum) {              // MODIFIED LINE
        highestKey = key;
        highestNum = value;                // ADDED LINE
    }
}