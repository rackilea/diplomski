public static void main(String [] args) {
    String parentId = "parentId";
    String leadingNumber = "leadingNumber";
    System.out.println(join(parentId, leadingNumber));
    parentId = null;
    System.out.println(join(parentId, leadingNumber));
    parentId = "";
    System.out.println(join(parentId, leadingNumber));
}

public static String join(String parentId, String leadingNumber) {
    List<String> list = (List<String>)Arrays.asList(new String[]{parentId, leadingNumber}).stream().filter(s -> s != null && s != "").collect(Collectors.toList());
    return String.join(":", list);
}