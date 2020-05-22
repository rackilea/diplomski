public static void main(String[] args) {
    String[] strArray = new String[]{
            "one",
            "two",
            "three"
    };
    for(int i = 0; i < strArray.length; i++){
        String firstItem = strArray[i];
        String secondItem = strArray[(i + 1) % strArray.length];
        System.out.println("Comparing [" + firstItem + "] and [" + secondItem + "]");
    }
}