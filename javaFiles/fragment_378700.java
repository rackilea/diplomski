public static ArrayList<?> returnProper(String type) {
    if(type.length() == 1 && "ISD".contains(type)) {
        return new ArrayList();
    } else {
        System.out.println("Invalid type");
        return null;
    }
}