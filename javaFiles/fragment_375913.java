private final LinkedBlockingQueue<Map.Entry<String, Long>> clientidToTimestampHolder =
    new LinkedBlockingQueue<>();

public void add(final String clientid, final Long timestamp) {
  clientidToTimestampHolder.offer(Maps.immutableEntry(clientid, timestamp));
}

public void processData() {
  final List<Map.Entry<String, Long>> entries = new ArrayList<>();
  clientidToTimestampHolder.drainTo(entries);
  for (Map.Entry<String, Long> entry : entries) {
    String clientid = entry.getKey();
    long timestamp = entry.getValue();
    boolean isUpdated = isUpdatedClient(clientid, timestamp);
    if (!isUpdated) {
      updateClient(String.valueOf(clientid));
    }
  }
}