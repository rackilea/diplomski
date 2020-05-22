List<ListDataContent> list = 
    konditions.stream()
              .filter(kondition -> !kondition.getStatusKz().equals(StatusKz.OLD))
              .flatMap(kondition -> 
                 kondition.getTerminTilgkonditions()
                          .stream()
                          .filter(tilg -> !tilg.getStatusKz().equals(StatusKz.OLD))
                          .map(tilg -> new AbstractMap.SimpleEntry<>(kondition, tilg))
              )
              .map(e -> new TerminKondTilgListContent(e.getValue(), e.getKey().getChangeDatum(), funds))
              .collect(Collectors.toList());