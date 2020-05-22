public int getIndexWithName(List<Animal> animals, String name){
    for (int index = 0; index < animals.size(); index++){
       if (name.equals(animals.get(index).getName())){
           return index;
       }
    }
    return -1;
}