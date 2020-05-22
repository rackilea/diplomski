Map<String,String> buttonStatus = new HashMap<String,String>();

for (String button : totalButtons) {
    String parts[] = button.split("-");
    buttonStatus.put(parts[0], parts[1]);
}

for (String button : statusButtons) {
    String parts[] = button.split("-");
    if (buttonStatus.containsKey(parts[0])) {
        buttonStatus.put(parts[0], parts[1]);
    }
    // Java 8 has a "replace" method that will change the value only if the key
    // already exists; unfortunately, Android doesn't support it
}