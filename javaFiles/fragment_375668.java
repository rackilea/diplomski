import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TreeViewTest extends Application {

    @Override
    public void start(final Stage stage) {
        StackPane sceneRoot = new StackPane();

        // create the tree model
        CheckBoxTreeItem<String> parent1 = new CheckBoxTreeItem<>("parent 1");
        CheckBoxTreeItem<String> parent2 = new CheckBoxTreeItem<>("parent 2");
        CheckBoxTreeItem<String> child1_1 = new CheckBoxTreeItem<>("child 1-1");
        CheckBoxTreeItem<String> child1_2 = new CheckBoxTreeItem<>("child 1-2");
        CheckBoxTreeItem<String> child2_1 = new CheckBoxTreeItem<>("child 2-1");
        CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>("root");

        // attach the nodes
        parent1.getChildren().addAll(child1_1, child1_2);
        parent2.getChildren().addAll(child2_1);
        root.getChildren().addAll(parent1, parent2);

        // display everything
        root.setExpanded(true);
        parent1.setExpanded(true);
        parent2.setExpanded(true);

        // create the treeView
        final TreeView<String> treeView = new TreeView<>();
        treeView.setShowRoot(false);
        treeView.setRoot(root);

        // set the cell factory UPDATED
        treeView.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>() {

            @Override
            public TreeCell<String> call(TreeView<String> param) {
                TreeCell<String> cell = new MyTreeCell<>();

                ((MyTreeCell) cell).getCheckBox().setOnMouseClicked(e -> {
                    if (!cell.getTreeItem().isLeaf())
                        if (e.isControlDown() && e.getButton() == MouseButton.PRIMARY)
                            System.out.println("CTRL-clicked");
                });

                return cell;
            }
        });

        // display the tree
        sceneRoot.getChildren().addAll(treeView);
        Scene scene = new Scene(sceneRoot, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}