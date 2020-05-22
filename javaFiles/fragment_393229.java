public Optional<Schema> getSchema(final String clientId) {
  for (ProcessMetadata metadata1 : processMetadataList) {
    if (metadata1.getClientId().equalsIgnoreCase(clientId)) {
      String deviceId = metadata1.getDeviceId();
      for (ProcMetadata metadata2 : procMetadataList) {
        if (metadata2.getDeviceId().equalsIgnoreCase(deviceId)) {
          return Optional.of(metadata2.getSchema());
        }
      }
      // adding a break here ensures the search doesn't become quadratic
      break;
    }
  }
  return Optional.absent();
}