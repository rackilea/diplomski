@FXML
protected void recipeEditListViewOnMouseClicked() {
    System.out.println("method started");

    editRecipeList.setDisable(true);
    Task<List<Document>> getRecipesTask = new Task<List<Document>>() {
        @Override
        public List<Document> call() throws Exception {
            return mongoDatabase.getCollection("recipes")
                    .find(eq("name", "somethng");
        }
    };

    getRecipesTask.setOnSucceeded(e -> {
        editRecipeList.setDisable(false);
        List<Document> recipesForEditingClick = getRecipesTask.getValue();
        // process results here...

        //etc
    });

    Thread thread = new Thread(getRecipesTask);
    thread.setDaemon(true);
    thread.start();
}