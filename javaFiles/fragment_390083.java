public Product(String json ){
    Gson gson=new Gson();
    try{
        Product product =gson.fromJson(json, Product.class);
        if (product!=null){
            System.out.println("Name: " +product.getProduct());
        }
    }catch (Exception e){
        System.out.println("failed: " +e.getMessage());
    }
}