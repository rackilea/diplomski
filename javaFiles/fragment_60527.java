RevWalk revWalk = new RevWalk( repository );
revWalk.markStart( revWalk.parseCommit( repository.resolve( Constants.HEAD ) ) );
revWalk.setTreeFilter( PathFilter.create( "path/to/file.txt" ) );
revWalk.sort( RevSort.COMMIT_TIME_DESC );
revWalk.sort( RevSort.REVERSE, true );
RevCommit commit = revWalk.next();
...
revWalk.dispose();