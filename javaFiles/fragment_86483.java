File workingCopyLocation = new File( ... );

SvnOperationFactory operationFactory = new SvnOperationFactory();
SvnLog logOperation = operationFactory.createLog();
logOperation.setSingleTarget(
        SvnTarget.fromFile( workingCopyLocation )
);
logOperation.setRevisionRanges( Collections.singleton(
        SvnRevisionRange.create(
                SVNRevision.create( 1 ),
                SVNRevision.HEAD
        )
) );
Collection<SVNLogEntry> logEntries = logOperation.run( null );
System.out.println( "logEntries = " + logEntries );