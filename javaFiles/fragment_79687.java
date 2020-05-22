public class PizzaMenu {

    private List<String> pizzas = new ArrayList<>();

    public void add(String name) {
        pizzas.add(name);
    }

    public List<String> getPizzas() {
        return pizzas;
    }

    // You can also move this to another class
    public static void main() {
        PizzaMenu menu = new PizzaMenu();
        menu.add("Cheese");

        for (String pizza : menu.getPizzas()) {
            System.out.println(pizza);
        }
    }
}