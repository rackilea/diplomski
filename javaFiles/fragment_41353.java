public static void main(String[] args) {

    String SCBHL_NEW="abc$#def$#ghi";

    String scbCCNewArray [] = SCBHL_NEW.split("\\$#");

    for(String str: scbCCNewArray){
        System.out.println(str);
    }

}