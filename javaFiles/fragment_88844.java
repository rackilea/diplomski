@Test
public void testLastModifiedInComposite() throws IOException {
    CompositeFileListFilter<File> compositeFileListFilter = new CompositeFileListFilter<>();
    compositeFileListFilter.addFilter(new AcceptAllFileListFilter<>());
    compositeFileListFilter.addFilter(new IgnoreHiddenFileListFilter());
    compositeFileListFilter.addFilter(new SimplePatternFileListFilter("*.foo"));
    compositeFileListFilter.addFilter(new LastModifiedFileListFilter(120));

    given(this.fileMock.getName())
            .willReturn("test.foo");

    given(this.fileMock.lastModified())
            .willReturn(System.currentTimeMillis());

    List<File> filteredFiles = compositeFileListFilter.filterFiles(new File[] { this.fileMock });

    assertTrue(filteredFiles.isEmpty());

    compositeFileListFilter.close();
}