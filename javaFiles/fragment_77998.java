@HK2
@Test
public class PizzaServiceNGTest {

    @Inject
    PizzaService pizzaService;

    @Inject
    Provider<PizzaService> pizzaServiceProvider;

    public void testProviderInjection() {
        Pizza pizza;

        // pizza with the works
        pizza = pizzaServiceProvider.get()
            .withPeperoni()
            .withBacon()
            .withCheese()
            .bake();

        assertTrue(pizza.peperoni);
        assertTrue(pizza.bacon);
        assertTrue(pizza.cheese);

        // naked pizza
        pizza = pizzaServiceProvider.get()
            .bake();

        assertFalse(pizza.peperoni);
        assertFalse(pizza.bacon);
        assertFalse(pizza.cheese);
    }

    public void testDirectInjection() {
        Pizza pizza;

        // pizza with the works
        pizza = pizzaService
            .withPeperoni()
            .withBacon()
            .withCheese()
            .bake();

        assertTrue(pizza.peperoni);
        assertTrue(pizza.bacon);
        assertTrue(pizza.cheese);

        // naked pizza
        pizza = pizzaService
            .bake();

        // this is where it goes wrong: the pizzaService hasn't been reset and
        // is messing up the order!
        assertFalse(pizza.peperoni);    // will fail
        assertFalse(pizza.bacon);   // will fail
        assertFalse(pizza.cheese);  // will fail
    }

}