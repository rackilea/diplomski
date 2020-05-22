public class JsonTest {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Product prod = new Product(1, "p1");

        ProductMedia pm = new ProductMedia(1, "uuid1");
        ProductMedia pm2 = new ProductMedia(2, "uuid2");

        prod.getMediaList().add(pm);
        prod.getMediaList().add(pm2);


        Product prod1 = new Product(2, "p2");

        ProductMedia pm3 = new ProductMedia(3, "uuid3");
        ProductMedia pm4 = new ProductMedia(4, "uuid4");

        prod1.getMediaList().add(pm3);
        prod1.getMediaList().add(pm4);

        Product[] pList = {prod, prod1};

        mapper.writeValue(System.out, pList);
    }
}