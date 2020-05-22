RevWalk walk = new RevWalk( repository );
walk.sort( RevSort.COMMIT_TIME_DESC, true );
walk.sort( RevSort.REVERSE , true );
RevCommit commit = walk.next();
while( commit != null ) {
  // use commit
  commit = walk.next();
}
walk.close();