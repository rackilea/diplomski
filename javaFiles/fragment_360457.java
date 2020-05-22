// I suspect that #addFirst method returns added list element
PositionInterface<K> last = keyList.addFirst((K) iterator.getData().getKey());
iterator = map.after(iterator);

for(int i = 0; i < size - 1; i++)
{
    // I suspect that #addAfter method returns added list element
    PositionInterface<K> last = keyList.addAfter(last, (K) iterator.getData().getKey());
    iterator = map.after(iterator);

}