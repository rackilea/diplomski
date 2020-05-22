Map<Material, Integer> stock = new HashMap<>();
Material material = new Material(...);
stock.put(material, 100);
int quantity = stock.getOrDefault(material, 0); // Java 8
int quantity = 0; // Java 7
{
    Integer q = stock.get(material);
    if (q != null) {
        quantity = q;
    }
}