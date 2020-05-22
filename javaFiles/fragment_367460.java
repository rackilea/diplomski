class MyJsonObject {
    private Menu menu;
    //general getters and setters
    //toString()
}

class Menu {
    private List<Pizza> pizza;
    //general getters and setters
    //toString()
}

class Pizza {
    private int nr;
    private String description;
    private List<Ingredient> ingredient;
    @JsonProperty("Picture")
    private String picture;
    //general getters and setters
    //toString()
}

class Ingredient {
    private int id;
    private String description;
    private String priceSmall;
    private String priceMedium;
    private String priceBig;
    //general getters and setters
    //toString()
}