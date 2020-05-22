private static String viewResult(List<String> list1, List<String> list2, List<String> duplicate){
    String result;
    StringBuilder SB = new StringBuilder("</br>");
    SB.append("Entries only on LEFT: </br>");
    list1.forEach(e -> SB.append(e + "</br>"));
    SB.append("Entries only on RIGHT: </br>");
    list2.forEach(e -> SB.append(e + "</br>"));
    SB.append("Entries full difference : </br>");
    duplicate.forEach(e -> SB.append(e + "</br>"));
    result = SB.toString();
    return result;
}