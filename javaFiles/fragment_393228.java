public Optional<Schema> getSchema(String clientId) {
  ProcessMetadata process = processMetadataByClientId.get(clientId);
  if (process != null) {
    ProcMetadata proc = procMetadataByDeviceId.get(process.getDeviceId());
    if (proc != null) {
      return Optional.of(proc.getSchema());
    }
  }
  return Optional.absent();
}