FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SliderVariable.fxml"));
fxmlLoader.setRoot(this);
fxmlLoader.setController(this);

// set FXMLLoader's classloader!
fxmlLoader.setClassLoader(getClass().getClassLoader());

try {
    fxmlLoader.load();
} catch (IOException exception) { }