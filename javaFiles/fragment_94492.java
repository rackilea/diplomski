private String getKeyword(String id) {
    String keyword = "";
    switch (id.substring(1, 2)) {
        case "E":
            keyword = "英語";
            break;
        case "M":
            keyword = "数学";
            break;
        case "W":
            keyword = "統合";
            break;
    }
    if ("W".equals(id.substring(4, 5))) keyword = "統合";
    return keyword;
}