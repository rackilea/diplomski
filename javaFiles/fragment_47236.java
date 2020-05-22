public class DesktopPaneTest extends ApplicationTest {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new DesktopPane(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void should_drag_file_into_trashcan() {
        // given:
        rightClickOn("#desktop").moveTo("New").clickOn("Text Document");
        write("myTextfile.txt").push(ENTER);

        // when:
        drag(".file").dropTo("#trash-can");

        // then:
        verifyThat("#desktop", hasChildren(0, ".file"));
    }
}