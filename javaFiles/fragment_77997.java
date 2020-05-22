@Path('pizza')
public class PizzaResource {

    @Inject
    PizzaService pizzaService;

    @GET
    public Response getPizza() {
        Pizza pizza = pizzaService
            .withPeperoni()
            .withCheese()
            .bake();

        return Response.ok(pizza).build();
    }
}