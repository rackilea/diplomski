// do this once, in the constructor or wherever you create these lists
// even better discard the lists and use the mappings everywhere
Map<String, ProcessMetadata> processMetadataByClientId = new HashMap<>();
for (ProcessMetadata process : processMetadataList) {
  processMetadataByClientId.put(process.getClientId(), process);
}

Map<String, ProcMetadata> procMetadataByDeviceId = new HashMap<>();
for (ProcMetadata metadata2 : procMetadataList) {
  procMetadataByDeviceId.put(proc.getDeviceId(), proc);
}