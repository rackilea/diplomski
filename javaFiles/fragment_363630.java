List<String> services = Arrays.asList("serviceA", "serviceC", "serviceB");
List<String> servicesPaths = Arrays.asList("serviceA-bla-bla", "serviceB-bla-bla", "serviceC-bla-bla");
List<String> sortedServices = servicesPaths.stream()
            .sorted((a, b) -> Integer.compare(
                    services.indexOf(a.substring(0, a.indexOf("-"))), 
                    services.indexOf(b.substring(0, b.indexOf("-")))))
            .collect(Collectors.toList());