@Root
  static class ProcessConfiguration {

    @Attribute
    Long id;

    @ElementList(name = "EquipmentConfigurations")
    List<EquipmentConfiguration> equipmentConfigurations = new ArrayList<>();
  }