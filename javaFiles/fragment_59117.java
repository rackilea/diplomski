public static ArrayList<Item> sortValue(ArrayList<Item> example) {
    Item aux = null;
    for(int i = 0; i < example.size(); i++){
        for(int j = 0; j < example.size() - 1; j++){
            if(example.get(j).getValue() > example.get(j + 1).getValue()){
                aux = example.get(j);
                example.set(j, example.get(j + 1));
                example.set(j + 1, aux);
            }
        }
    }
    return example;
}