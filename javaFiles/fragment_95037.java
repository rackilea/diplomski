public class Test {

static String jsonString = "{ \"requestToken\":0, \"responseCode\":2, \"objectType\":\"com.test.Restaurant\", \"error\":null, \"data\":[ { \"id\":1, \"name\":\"Name\", \"addressCity\":\"Warszawa\", \"addressStreet\":\"Kopernika\", \"addressStreetNumber\":\"4\", \"addressApartmentNumber\":\"17\", \"categories\":[ { \"id\":1, \"restaurantId\":1, \"name\":\"Breakfast\", \"description\":\"Description\", \"dishes\":[ { \"id\":11, \"categoryId\":1, \"name\":\"Dish 1\", \"description\":\"Descr\", \"price\":8.99, \"photoId\":51 }, { \"id\":21, \"categoryId\":1, \"name\":\"Dish 2\", \"description\":\"Descr\", \"price\":6.99, \"photoId\":41 }, { \"id\":31, \"categoryId\":1, \"name\":\"Dish 3\", \"description\":\"Descr\", \"price\":14.99, \"photoId\":61 } ] }, { \"id\":2, \"restaurantId\":1, \"name\":\"Obiady\", \"description\":\"Opis kategorii\", \"dishes\":[ { \"id\":41, \"categoryId\":2, \"name\":\"Danie 4\", \"description\":\"Descr\", \"price\":6.99, \"photoId\":0 }, { \"id\":61, \"categoryId\":2, \"name\":\"Danie 5\", \"description\":\"Descr\", \"price\":8.0, \"photoId\":0 }, { \"id\":101, \"categoryId\":2, \"name\":\"Nowy obiad\", \"description\":\"\", \"price\":111.0, \"photoId\":0 } ] }, { \"id\":3, \"restaurantId\":1, \"name\":\"Pasta\", \"description\":\"Opis kategorii\", \"dishes\":[ ] }, { \"id\":4, \"restaurantId\":1, \"name\":\"Przystawki\", \"description\":\"Opis kategorii\", \"dishes\":[ ] }, { \"id\":11, \"restaurantId\":1, \"name\":\"Some category\", \"description\":\"test\", \"dishes\":[ ] }, { \"id\":51, \"restaurantId\":1, \"name\":\"Sushi\", \"description\":\"\", \"dishes\":[ ] } ] } ] }";

public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Response res = mapper.readValue(jsonString, Response.class);
}

public static class Response {
    public String requestToken;
    public List<Restaurant> data;

    public Response(){}

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public List<Restaurant> getData() {
        return data;
    }

    public void setData(List<Restaurant> data) {
        this.data = data;
    }
}

public static class Restaurant {
    public List<Category> categories;

    public List<Category> getCat() {
        return categories;
    }

    public void setCat(List<Category> categories) {
        this.categories = categories;
    }

    public Restaurant(){}
}

public static class Category {
    public List<Dish> dishes;

    public Category(){}

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}

public static class Dish {

    public String id, categoryId, name, description;
    public float price;
    public int photoId;

    public Dish(){}

}
}