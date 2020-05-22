private Map<Integer, Service> servicesByCode;

@PostConstruct
private void postConstruct() {
    servicesByCode = new HashMap<>();
    servicesByCode.put(1, service1);
    servicesByCode.put(2, service2);
    servicesByCode.put(3, service3);
    ...
}