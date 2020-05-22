String[] items ={"ch","sh","s","x","z"};
for (String item : items) {
    if (sWord.substring(0,sWord.length()).equalsIgnoreCase(item)) {
       lblPluralOutput.setText(sWord + "es");
        break; 
    } 
}