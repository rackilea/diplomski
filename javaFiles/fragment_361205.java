FileRepositoryBuilder builder = new FileRepositoryBuilder();
Repository repo = builder.setGitDir(new File("localrepositary"+"\\.git")).setMustExist(true).build();
Git git = new Git(repo);
Iterable<RevCommit> log = git.log().call();
for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext();) {
  RevCommit rev = iterator.next();
  logMessages.add(rev.getFullMessage());
}