public static void main(String[] args) {
    String links = "http://www.website1.com/thistext\n" + 
                   "http://www.website1.com/othertext\n" +
                   "http://www.website1.com/thistext";
    String[] linksArray = links.split("\n");

    for (String link : linksArray) {
        if (link.contains("thistext")) {
            System.out.println(link);
        }
    }

}