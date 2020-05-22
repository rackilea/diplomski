@Rule
public final ExpectedException expectedException = ExpectedException.none();

@Test
public void given_NamedParameterizedFileSet_when_SavedWithInvalidFileName_then_Exception() throws Exception {
    String invalidFullPathToFileSet = fsPathDir + invalidBackupName;
    FileSet fs = new FileSet(backupName, dest);

    expectedException.expect(IOException.class);

    FileSet.save(invalidFullPathToFileSet, fs);
}