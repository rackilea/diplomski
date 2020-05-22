public void postInit() {
    DataCenter dataCenter = Utils.getDataCenter();
    Environment environment = Utils.getEnvironment();

    for (Type consType : Type.values()) {
      if (!consType.isEnabled(dataCenter, environment)) {
        continue;
      }
      handlers.add(new Handler(consType, consType.getPoolSize(environment)));
    }
}