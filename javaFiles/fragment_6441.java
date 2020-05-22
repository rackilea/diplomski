public <K> K[] toArray(Class<K> clazz)
{
    K[] result = (K[])Array.newInstance(clazz,this.size());
    int index  = 0;
    for(K k : this)
        result[index++] = k;
    return result;
}