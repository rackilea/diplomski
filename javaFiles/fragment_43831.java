public static void main(String [] args) {
    List<Object> fooList = new ArrayList<Object>();
    String fooString = "";
    System.out.println((ParameterizedType)fooList.getClass().getGenericSuperclass());
    System.out.println((ParameterizedType)fooString.getClass().getGenericSuperclass());
}