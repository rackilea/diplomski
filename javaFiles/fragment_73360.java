public static int makeNumber(String name) {
        int product = 1;
        //iterate through each character in the String name
        for (int i = 0; i < name.length(); i++) {
            //get the character value
            int charVal = (name.charAt(i) - 'A') + 1; 
            //multiply the product by the character value
            product *= charVal;
        }
        return product;
    }
}