@Rule
public TemporaryFolder tempFolder = new TemporaryFolder();

@Test
public void testCreateFile() throws IOException{
    File file = tempFolder.newFile("test.txt");
    assertTrue(file.exists());
}