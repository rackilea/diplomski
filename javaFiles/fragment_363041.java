try {
    String str = new String("سلام".getBytes(), "UTF-8");
    System.out.println(str);
}
catch (Exception e) {
    System.out.println("Something went wrong.");
}