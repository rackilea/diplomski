public Item find(int id) throws ItemNotFoundException {
    for (int pos = 0; pos < size; ++pos){
        if (id == list[pos].getItemNumber()){
            return list[pos];
        }
    }
    throw new ItemNotFoundException(id);
}