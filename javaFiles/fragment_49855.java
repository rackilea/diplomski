public void printSelectedValues() {
    for(String s : myEoList.getSelectedValueList()) {
        if(myEoMap.containsKey(s)) {
            System.out.println("Key " + s + " found! The value is: " + myEoMap.get(s));
        } else {
            System.err.println("Oops, no value found");
        }
    }
}