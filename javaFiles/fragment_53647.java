public class AssertProduct {

    private JsonElement product;

    public AssertProduct(JsonElement product) {
        this.product = product;
    }

    public static AssertProduct withProduct(JsonElement product) {
        return new AssertProduct(product);
    }

    AssertProduct ofName(String name) {
        Assert.assertEquals(name, product.getAsJsonObject().get("name").getAsString());
        return this;
    }

    AssertProduct ofType(String type) {
        Assert.assertEquals(type, product.getAsJsonObject().get("type").getAsString());
        return this;
    }
}