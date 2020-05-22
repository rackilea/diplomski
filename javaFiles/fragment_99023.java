public Object getTheLastElement(){
    if (list.isEmpty()) {
        return null;
    }
    return list.get(list.size()-1);
}