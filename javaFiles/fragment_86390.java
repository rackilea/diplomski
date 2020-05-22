public class AppRunner {
  GatewayContainer container;

  public AppRunner(GatewayContainer container) {
      this.container = container;
  }

  public static void main(String[] args) {
      EasyDI context = new EasyDI();
      context.bindProvider(GatewayContainer.class, new GatewayProvider());
      final AppRunner runner = context.getInstance(AppRunner.class);
  }
}