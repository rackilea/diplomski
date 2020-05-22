...
else{
//Delete rectangles added before ( or check if this one isnt already dispayed)
if(group.getSelectedToggle().getUserData() instanceof Node)
     vbox.getChildren().add((Node)group.getSelectedToggle().getUserData());
}