public class HasTempFolder {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile= folder.newFile("myfile.txt");
        File createdFolder= folder.newFolder("subfolder");
        // ...
    }
}