public static void main(String[] args) throws DatatypeConfigurationException {
    String result ="{\"username\": \"sdrG\", \"size\": 965204,  \"filename\": \"test.doc\"}";
     JSONObject jObject  = new JSONObject(result); // json
        String size = String.valueOf((Integer) jObject.get("size"));
        System.out.println(size);
}