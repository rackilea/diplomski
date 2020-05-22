public class GatewayContainer {
  Set<Gateway> gateways;

  public void setGateways(Set<Gateway> gateways) {
    this.gateways = gateways;
  }
}

public class GatewayProvider implements Provider<GatewayContainer> {

  @Override
  public GatewayContainer get() {
      try {
          File file = new File(getClass().getResource("/gateways.json").toURI());
          Type listType = new TypeToken<Set<Gateway>>() {
          }.getType();
          Set<Gateway> set = new Gson().fromJson(new FileReader(file), listType);
          GatewayContainer container = new GatewayContainer();
          container.setGateways(set);
          return container;
      } catch (URISyntaxException | FileNotFoundException e) {
          e.printStackTrace();
      }
      return new GatewayContainer();
  }
}