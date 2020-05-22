public Object remove(Object obj){
    int index = -1;
    for (int i = 0; i < data.length; i++) {
        if (data[i] == obj) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        return remove(index);
    }
    return null;
}