String servicePathArray[] = {"SH11", "SH13", "SH17",
                             "SH110", "SH111", "SH112", "SH115"};
List<ServicePath> collection = Stream.of(servicePathArray)
                                     .map(ServicePath::new)
                                     .collect(Collectors.toList());

System.out.println(collection);