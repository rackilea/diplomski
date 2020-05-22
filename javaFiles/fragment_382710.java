private static void populateList(int i){
    children.clear();
    for(int p = 0; p < values.size(); p++){
        children.add(values.get(i++%values.size()));
    }
}