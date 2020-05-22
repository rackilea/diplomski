Git.cloneRepository()
  .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "user", "password" ) );
  .setURI( remoteRepoUrl )
  .setDirectory( localDirectory )
  .setCloneAllBranches( true )
  .call();