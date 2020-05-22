List<Report> successReports = transferStatusMap.entrySet()
          .stream()
          .filter(e -> e.getValue() == TransferStatus.SUCCESS)
          .map(Entry::getKey)
          .collect(Collectors.toList());

 if(!reports.isEmpty()){
     dbMetadataWriter.writeMetadata(successReports);
 }