Stage stage = new Stage();
Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));

final Table table = new Table(skin);
final Label[] labels = new Label[tableData.length]; //keep references to the labels for updating them.

final ChangeListener incrementListner = new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        IncrementButton incrementButton = (IncrementButton)actor;
        int row = incrementButton.rowNumber;
        tableData[row] += incrementButton.decrement ? -1 : 1;
        labels[row].setText(Integer.toString(tableData[row]));
    }
};

table.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
for(int i = 0; i < tableData.length; i++){
    IncrementButton decrementButton = new IncrementButton(skin, "minus", i, true);
    decrementButton.addListener(incrementListner);
    IncrementButton incrementButton = new IncrementButton(skin, "plus", i, false);
    incrementButton.addListener(incrementListner);

    table.add(decrementButton);
    labels[i] = table.add(Integer.toString(i)).getActor();//Add number label and keep reference to it in labels array for the change listener to look up
    table.add(incrementButton);
    table.row();
}

stage.addActor(table);

Gdx.input.setInputProcessor(stage);