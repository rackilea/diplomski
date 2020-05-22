// stores the data coming from a single Element ("item") of the document
class Product {
    private String productType;
    private String hyperLinkParam;
    public setHyperLinkParam( String hlp ){
        hyperLinkParam = hlp;
    }
    public setProductType( String pt ){
        productType = pt;
    }
}

// Container for a list of products from an inventory
class ProductList {
    private ArrayList <Product> pl = new ArrayList<Product> ();
    public ProductList() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputStream url = getClass().getResourceAsStream("inventory.xml");
        Document doc = db.parse(url);
        doc.getDocumentElement().normalize();

        // loop through each item
        NodeList items = doc.getElementsByTagName("item"); 
        for (int i = 0; i < items.getLength(); i++){
            Element e = (Element) items.item(i);
            // create the single product from the current item
            Product prod = new Product();
            prod.setHyperLinkParam( e.getAttribute("name").toString() );
            prod.setProductType( getTextValue( e, "productType") );
            // add it to the list
            pl.add( prod );
        }
    }

    void showList(){
        for( Product prod: pl ){
        System.out.print("getHyperLinkParam: " + prod.getHyperLinkParam());
            System.out.println("getProductType: " + prod.getProductType());
        }
    }
}