import javafx.fxml.FXML
import javafx.scene.control.Label

class MainWindowController : Initializable {
    @FXML 
    var helloLabel: Label? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println("Label is null? ${helloLabel == null}")
    }
}