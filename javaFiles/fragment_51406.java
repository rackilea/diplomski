public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<String, String>();

        myMap.put("1.123456", "-1.123456");
        myMap.put("2.123456", "-2.123456");

        for(String keys : myMap.keySet()){

            double keyDouble = Double.parseDouble(keys);
            double valueDouble = Double.parseDouble(myMap.get(keys));

            System.out.println(String.format("Key: %f Value: %f", keyDouble, valueDouble));
        }
    }