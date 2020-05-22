PullResult result = git.pull()
    .setCredentialsProvider(user)
    .setRemote("origin")
    .setRemoteBranchName("master")
    .call();

if (result.isSuccessful()) {
  ...
} else {
  ...
}