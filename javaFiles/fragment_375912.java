public void processData() {
  synchronized (clientidToTimestampHolder) {
    for (Map.Entry<String, Long> entry : clientidToTimestampHolder.entries()) {
      String clientid = entry.getKey();
      long timestamp = entry.getValue();
      boolean isUpdated = isUpdatedClient(clientid, timestamp);
      if (!isUpdated) {
        updateClient(String.valueOf(clientid));
      }
    }
    clientidToTimestampHolder.clear();
  }
}