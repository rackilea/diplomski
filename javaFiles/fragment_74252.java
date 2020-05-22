Ordering<Map.Entry<Key, Value>> entryOrdering = Ordering.from(valueComparator)
  .onResultOf(new Function<Entry<Key, Value>, Value>() {
    public Value apply(Entry<Key, Value> entry) {
      return entry.getValue();
    }
  }).reverse();
// Desired entries in desired order.  Put them in an ImmutableMap in this order.
ImmutableMap.Builder<Key, Value> builder = ImmutableMap.builder();
for (Entry<Key, Value> entry : 
    entryOrdering.sortedCopy(map.entrySet())) {
  builder.put(entry.getKey(), entry.getValue());
}
return builder.build();
// ImmutableMap iterates over the entries in the desired order