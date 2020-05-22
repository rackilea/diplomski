@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class CartModelTest {

    @Test
    public void addToCart() throws Exception {
        CartModel cartModel = new CartModel();
        assertEquals(0, cartModel.totalAmount, 0);
        assertEquals(0, cartModel.products);
        cartModel.addToCart(10.2f);
        assertEquals(10.2f, cartModel.totalAmount, 0);
        assertEquals(1, cartModel.products);
    }
}