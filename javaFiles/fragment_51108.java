Map<TransferStatus, List<Report>> map = 
     transferStatusMap.entrySet()
                      .stream()
                      .collect(Collectors.groupingBy(
                            Entry::getValue,
                            Collectors.mapping(Entry::getKey, Collectors.toList()));