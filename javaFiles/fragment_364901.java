public void test() {

    RemoveDuplicatesStringArray rd = new RemoveDuplicatesStringArray();

    String[] strArray = {"ellen","talk","show","ellen","talk","show","ellen","talk"};
    List<String> checkList = rd.removeDups(strArray);

    assertEquals(Arrays.asList("ellen","talk","show").tostring(),checkList.toString());
}