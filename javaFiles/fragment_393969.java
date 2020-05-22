public static void main(String[] args){

    String names[] = {"abc@gmail.com", "def@gmail.com","ghi@gmail.com","jkl@gmail.com"};
    JList<String> places = new JList<String>(names) ;

    places.setSelectedIndices(new int[]{0,1,2});

    String[] emailIDs = places.getSelectedValuesList().toArray(new String[]{});

    for(String s : emailIDs){
        System.out.println(s);
    }
}