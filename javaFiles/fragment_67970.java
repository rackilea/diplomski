public static void main(String[] args) {
        String[] m = {"12,000", "245.67"};
        for (String s : m){
            System.out.println(parseStringToInt(s));
        }
    }