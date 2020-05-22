public class TestFolderScan {
        @Rule
        public TemporaryFolder folder= new TemporaryFolder();

        @Test
        public void whenASingleFolderWithAFileThatPassesTheFilterThenItExistsInTheQueue() {
                File expectedFile = folder.newFile("file.txt");
                File endOfWorkFile = new File("EOW");
                Queue queue = ...;
                FolderScan subject = new FolderScan(folder.getRoot(), queue, new AllwaysPassesBlocker(),...);

                subject.run();

                expected = new Queue(expectedFile, endOfWorkFile);
                assertEquals(queue, expected);
        }
}