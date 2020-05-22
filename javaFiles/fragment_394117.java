public static void condense(ArrayList<String> array){
    for (int i = 0; i < array.size(); i++){
        array.set(i, array.get(i)+array.get(i + 1));
        array.remove(i + 1);
    }
}