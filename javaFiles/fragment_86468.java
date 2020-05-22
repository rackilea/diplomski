import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MultipleHashMapAccessDemo {

    protected Map<String, String> getProductCategoryMap() {
        Map<String, String> productCategoryMap = new HashMap<String, String>();

        productCategoryMap.put("Lux", "Soap");
        productCategoryMap.put("Pears", "Soap");
        productCategoryMap.put("Dove", "Soap");
        productCategoryMap.put("Colgate", "Paste");
        productCategoryMap.put("Babul", "Paste");
        productCategoryMap.put("Vico", "Paste");

        return productCategoryMap;
    }

    protected Map<String, Integer> getProductUnitsSoldMap() {
        Map<String, Integer> productUnitsSoldMap = new HashMap<String, Integer>();

        productUnitsSoldMap.put("Lux", 1000);
        productUnitsSoldMap.put("Pears", 3000);
        productUnitsSoldMap.put("Dove", 3010);
        productUnitsSoldMap.put("Colgate", 50);
        productUnitsSoldMap.put("Babul", 45);
        productUnitsSoldMap.put("Vico", 80);

        return productUnitsSoldMap;
    }

    protected Map<String, String> getExpectedProductCategoryMap(
            Map<String, String> productCategoryMap,
            Map<String, Integer> productUnitsSoldMap) {

        Map<String, String> expectedProductCategoryMap = new HashMap<String, String>();
        Set<String> categortSet = new HashSet<String>();

        Iterator iterator = productCategoryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> mEntry = (Map.Entry) iterator.next();
            categortSet.add(mEntry.getValue());
        }

        for (String category : categortSet) {
            int tempUnits = 0;
            String desiredProductName = null;

            for (Object object : productUnitsSoldMap.entrySet()) {
                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) object;

                String product = entry.getKey();
                if (category.equals(productCategoryMap.get(product))) {
                    if (tempUnits < entry.getValue()) {
                        tempUnits = entry.getValue();
                        desiredProductName = product;
                    }
                }
            }
            expectedProductCategoryMap.put(category, desiredProductName);
        }
        return expectedProductCategoryMap;
    }

    public static void main(String... strings) {

        MultipleHashMapAccessDemo accessDemo = new MultipleHashMapAccessDemo();
        Map<String, String> productCategoryMap = accessDemo
                .getProductCategoryMap();
        Map<String, Integer> productUnitsSoldMap = accessDemo
                .getProductUnitsSoldMap();

        Map<String, String> expectedProductCategoryMap = accessDemo
                .getExpectedProductCategoryMap(productCategoryMap,
                        productUnitsSoldMap);

        for (Object object : expectedProductCategoryMap.entrySet()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) object;

            System.out.print("Category name is : " + entry.getValue());
            System.out.println(" And Product name is : " + entry.getKey());
        }
    }
}