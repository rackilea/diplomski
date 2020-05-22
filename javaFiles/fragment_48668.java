btnCube = new TextButton("Cube", btnStyle);
btnCube.setUserObject(ElementType.CUBE); //example enum you need to create
btnCube.addListener(commonListener);
toolButtons.add(btnCube);

//...
void setSelectedTool(Button button){
    WorldController.element = (ElementType)button.getUserObject();
}