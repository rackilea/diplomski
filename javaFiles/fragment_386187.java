@DefaultProperty(value = "extension")
public class SpecializedButton extends HBox
{
    @FXML private HBox extension;

    public ObservableList<Node> getExtension() {
        return extension.getChildren();
    }
    // ... more component specific code
}