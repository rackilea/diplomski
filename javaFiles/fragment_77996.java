@Service
@PerLookup
public class PizzaService {

    Pizza pizza = new Pizza(); // naked pizza by default

    @Inject
    OvenService    oven; // just to show that I can use @Inject here

    public PizzaService withPeperoni() {
        pizza.peperoni = true;
        return this;
    }

    public PizzaService withCheese() {
        pizza.cheese = true;
        return this;
    }

    public PizzaService withBacon() {
        pizza.bacon = true;
        return this;
    }

    public Pizza bake() {
        return oven.bake(pizza);
    }
}