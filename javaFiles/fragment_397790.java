private int findHash(String key) {
    int hash = hashThis(key);

    // search for the next available element or for the next matching key
    while(data[hash] != AVAILABLE && data[hash].key() != key) {

        hash = (hash + 1) % capacity;
    }
    return hash;
}

public Object get(String key) {

    return data[findHash(key)].element();
}

public void put(String key, Object element) {

    data[findHash(key)] = new Node(key, element); 
}