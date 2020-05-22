private String name;
 private List<Device> devices; //all devices of the customer 

 public Customer(String name) {
      this.name = name;
      devices = new ArrayList<>();
 }

 public void registerDevice(Device d) {
      devices.add(d); 
 }