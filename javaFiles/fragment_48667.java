btnCube = new TextButton("Cube", btnStyle);
btnCube.setName("cube");
btnCube.addListener(commonListener);
toolButtons.add(btnCube);

//...
void setSelectedTool(Button button){
    WorldController.element = button.getName();
}