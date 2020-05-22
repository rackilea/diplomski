LsRemoteCommand ls = Git.lsRemoteRepository();
Collection<Ref> remoteRefs = ls
    .setRemote("url-to-remote-repo")
    .setHeads(true) // true by default, set to false if not interested in refs/heads/*
    .setTags(true)  // include tags in result
    .call();