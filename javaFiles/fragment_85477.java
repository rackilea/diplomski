@Module
public class ProductTwoModule {
  @Provides Product provideProduct(ProductTwo productTwo) {
    return productTwo;
  }
}

@Component(modules = ProductTwoModule.class)
public interface PackagerTwoComponent {
  Packager packager();
}