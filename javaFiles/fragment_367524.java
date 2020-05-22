private String message;

    public static String product;
    public static String tv="TV_SAT";
    public static String smart="SMART_OFFICE";

    public static String productSpec;

    public static int status;

    public String getProduct(){
        return Message.product;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProduct(String product){
        Message.product=product;
    }

    public void setProductSpec(String product){

        Message.productSpec=product;
    }

    public String getProductSpec(){

        return
                Message.productSpec;

    }
}