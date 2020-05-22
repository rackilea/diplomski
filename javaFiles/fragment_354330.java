@Parameters(name= "{index}: {1}")
public static Collection<Object[]> data() {
    Collection<File> _rv = IteratorUtils.toList( FileUtils.iterateFiles(testFilesDir, TrueFileFilter.INSTANCE, (IOFileFilter) null) );
    Collection<Object[]> rv = new ArrayList<>();
    for (File f : _rv)
        rv.add(new Object[]{f, f.getName()});
    return rv;
}