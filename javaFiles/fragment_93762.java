@FXML
private TextField ReferenceKey;

public static TextField referenceKeyPublic;

...

@Override
public void initialize(URL url, ResourceBundle rb) {
    ClassName.referenceKeyPublic = ReferenceKey;
}