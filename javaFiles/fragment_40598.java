@Rule
public TemporaryFolder temporaryFolder = new TemporaryFolder();

@Test
public void test() throws Exception {
    File child = temporaryFolder.newFolder("grandparent", "parent", "child"); //...

    assertEquals("child", child.getName());
    assertEquals("parent", child.getParentFile().getName());
    assertEquals("grandparent", child.getParentFile().getParentFile().getName());
    System.out.println(child.getAbsolutePath());
}