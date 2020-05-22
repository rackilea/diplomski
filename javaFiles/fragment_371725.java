List<PlayerResult> players = // ...
ListModel<PlayerResult> playersModel = new ListModel<PlayerResult>(players);
ListView<PlayerResult> list = new ListView<PlayerResult>("list", playersModel) {
    @Override
    protected void populateItem(ListItem<PlayerResult> item) {
        Label name = new Label("name", new PropertyModel<String>(item.getModel(), "player.name"));
        Label surname = new Label("surname", new PropertyModel<String>(item.getModel(), "player.surname"));
        Label results= new Label("results", item.getModelObject().getResults().size());

        ListView<Result> scoreList= new ListView<Result>("scoreList", item.getModelObject().getResults()){
             @Override
             protected void populateItem(ListItem<Result> resultItem) {
                   item.add(new Label("score", new PropertyModel<Integer>(resultItem.getModel(), "scoreValue ? ")));
             }
        }

        // ...

        item.add(name);
        item.add(surname);
        item.add(results);
        item.add(scoreList);
        // ...
    }
}