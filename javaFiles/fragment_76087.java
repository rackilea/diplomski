Stage stage = new Stage();

stage.act();
stage.draw();
//This is pretty much it, you can start adding actors to it now.


Table myTable = new Table();
myTable.setFillParent = true; // <-- sets initial table to fill it's parent (in this case the stage)
Scrollpane myScrollpane = new Scrollpane(); // <-- Add actors to hold by scrollpane

myTable.add(myScrollpane);
stage.addActor(myTable);
stage.addActor(myTable);