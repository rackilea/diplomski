class DevicesPojoFactory {
    @Autowired @Qualifier("uniformDistribution") 
    private DistributionService uniformDistribution;
    ObjectMapper mapper = new ObjectMapper();

    DevicesPojo[] readFromFile(String path) {
         DevicesPojo[] devicePojoArr = mapper.readValue(...);
         for (DevicesPojo dp: devicePojoArr) {
              dp.setDistribution(uniformDistribution);
         }
    }
}