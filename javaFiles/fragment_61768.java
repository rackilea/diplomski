private ArrayList<String> filters(ArrayList<String> resulting) {

    String regex = "[0-9]+";
    // This regex also works
    String regex = "\\d+";

    ArrayList<String> abc = new ArrayList<String>();

    for(int i = 0; i < resulting.size(); i++) {
        if(resulting.get(i).matches(regex)) {
            abc.add(resulting.get(i));
        }
    }
    return abc;
}