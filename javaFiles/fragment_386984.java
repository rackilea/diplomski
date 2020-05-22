private void start() throws IOException, SQLException {
    try (Connection conn = DBConnectionUtils.getConnectionFromSrcFolder("connection.properties")) {
        System.out.print("Enter the article id: > ");
        int id = Integer.parseInt(Keyboard.readInput());
        Article article = getArticleById(id, conn);
        // DO SOMETHING WITH ARTICLE
    }
}