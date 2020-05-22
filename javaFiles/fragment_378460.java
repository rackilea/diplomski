dataPoints.stream()
           .collect(
                 Collectors.collectingAndThen(
                      Collectors.groupingBy(
                         DataPoint::getUploadIndex, 
                         TreeMap::new, 
                         Collectors.toList()
                      )
                 ),
                      map -> new ArrayList(map.values())
           );