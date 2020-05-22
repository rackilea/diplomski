VBox questions = new VBox();
root.setCenter(questions);
questions.setOnDragOver(event ->
{
    if (event.getGestureSource() == currBtn && event.getDragboard().hasString())
    {
        event.acceptTransferModes(TransferMode.MOVE);
    }
    event.consume();
});
questions.setOnDragDropped(event ->
{
    Dragboard db = event.getDragboard();
    boolean success = false;
    if (db.hasString())
    {
        questions.getChildren().add(createQustionType(db.getString()));
        success = true;
    }
    event.setDropCompleted(success);
    event.consume();
});

questions.setOnDragDone(event ->
{
    System.out.println("Add clean up code");
    if (event.getTransferMode() == TransferMode.MOVE)
    {
        System.out.println("Drag Done");
    }
    event.consume();
});

VBox sidePanel = new VBox();
root.setLeft(sidePanel);
sidePanel.setMinWidth(100);
//sidePanel.setStyle("-fx-background-color: red");
sidePanel.setStyle("-fx-border-color: red; -fx-min-width: 100px;");
sidePanel.setSpacing(10);

String[] types = new String[]{"multiple choice", "long answer", "short answer"};
for (String type : types)
{
    Button btn = new Button(type);
    btn.getStyleClass().add("qBtn");
    btn.setStyle("-fx-border-color: black;");
    btn.setOnDragDetected(event ->
    {
        currBtn = (Button) event.getSource();
        System.out.println("Dragging node");
        Dragboard db = btn.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(btn.getText());
        db.setContent(content);

        event.consume();
    });
    sidePanel.getChildren().add(btn);
}