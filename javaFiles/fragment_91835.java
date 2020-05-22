public <T extends SomeCustomMap<K, V>> T getSubSet(...){
    T subset = (T)this.clone();
    subset.clear();

    return subset;
}