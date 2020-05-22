str = str.trim();
while(true) {
    Integer oldValue = wordCountMap.putIfAbsent(str, 1);
    if(oldValue != null) {
        if(wordCountMap.replace(str, oldValue, oldValue + 1))
          break; // Successfully incremented the existing count
    } else {
        break; // Added new count of 1
    }
}