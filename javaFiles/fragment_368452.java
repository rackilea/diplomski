public class LogLearningTest {
  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  private Git git;
  private File file;

  @Test
  public void testCountNumberOfCommitsOnFile() throws Exception {
    writeFile( "initial content" );
    commitAll( "Create file in folder" );
    commitAll( "Unrelated commit" );
    writeFile( "changed content" );
    commitAll( "Change file in folder" );
    git.commit().setMessage( "Other commit" ).call();

    Iterable<RevCommit> logs = git.log().addPath( "folder/file" ).call();
    int count = 0;
    for( RevCommit revCommit : logs ) {
      count++;
    }

    assertEquals( 2, count );
  }

  @Before
  public void setUp() throws GitAPIException {
    git = Git.init().setDirectory( tempFolder.getRoot() ).call();
    File folder = new File( git.getRepository().getWorkTree(), "folder" );
    folder.mkdir();
    file = new File( folder, "file" );
  }

  @After
  public void tearDown() {
    git.getRepository().close();
  }

  private void writeFile( String content ) throws IOException {
    FileOutputStream outputStream = new FileOutputStream( file );
    outputStream.write( content.getBytes( "UTF-8" ) );
    outputStream.close();
  }

  private void commitAll( String message ) throws GitAPIException {
    git.add().addFilepattern( "." ).call();
    git.commit().setMessage( message ).call();
  }

}