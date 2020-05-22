if(hashTableForWorld.containsKey(key))
{
    value = hashTableForWorld.get(key);
    value.add(probDes);
    hashTableForWorld.put(key, value);
}
else
{
    value = new ArrayList<String[]>();
    value.add(probDes);
    hashTableForWorld.put(key, value);
}