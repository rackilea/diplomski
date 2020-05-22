Git git = Git.open( localDirectory );
  git.push()
    .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "user",  "password" ) );
    .setRemote( newRemoteRepoUrl )
    .setForce( true )
    .setPushAll()
    .setPushTags()
    .call()