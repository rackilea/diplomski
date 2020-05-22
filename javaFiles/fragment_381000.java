public class ProductMapperClient1 extends Mapper<Product> {

    @Override
    protected void mapFromEntity(Product response, Map<String, Object> dynamicProperties) {
        // Actual mapping from Product and CLIENT_1 to map
        dynamicProperties.put("supplier", response.customString1);
        dynamicProperties.put("warehouse", response.customString2);
    }

    @Override
    protected void mapToEntity(Map<String, Object> dynamicProperties, String name, Product response) {
        // Actual mapping from map and CLIENT_1 to Product
        String property = (String) dynamicProperties.get(name);
        if ("supplier".equals(name)) {
            response.customString1 = property;
        } else if ("warehouse".equals(name)) {
            response.customString2 = property;
        }
    }
}