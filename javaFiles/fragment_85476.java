@Module
public class ProductOneModule {
  @Provides Product provideProduct(ProductOne productOne) {
    return productOne;
  }
}