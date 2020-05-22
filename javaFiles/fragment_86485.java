String repoLocation = "http://hamcrest.googlecode.com/svn/trunk";

// DAV allows access via http and https protocols
// use FSRepositoryFactory to access local repositories
// use SVNRepositoryFactory to access remote repositories via svn protocol
DAVRepositoryFactory.setup();
SVNRepository repository = DAVRepositoryFactory.create(
        SVNURL.parseURIEncoded( repoLocation )
);

repository.log(
        new String[]{ },
        0, -1,
        false, false,
        new ISVNLogEntryHandler()
        {
            @Override
            public void handleLogEntry( SVNLogEntry logEntry )
            {
                System.out.println( "logEntry = " + logEntry );
            }
        }
);