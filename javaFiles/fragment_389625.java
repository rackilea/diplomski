private class WrapperMap<K> extends HashMap<K, Integer>{
@Override
public Integer get(Object key){
    if (super.containsKey(key))
        return super.get(key);
    else{
        return 1;
    }
}
}