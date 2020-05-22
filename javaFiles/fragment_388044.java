public static void main(String[] args) throws Exception {
    Repository repository = new FileRepositoryBuilder()
            .setGitDir(new File("D:/Gitrepo/.git")).build();

    RevCommit headCommit = getHeadCommit(repository);
    RevCommit diffWith = headCommit.getParent(0);
    FileOutputStream stdout = new FileOutputStream(FileDescriptor.out);
    try (DiffFormatter diffFormatter = new DiffFormatter(stdout)) {
        diffFormatter.setRepository(repository);
        for (DiffEntry entry : diffFormatter.scan(diffWith, headCommit)) {
            diffFormatter.format(diffFormatter.toFileHeader(entry));
        }
    }
}

private static RevCommit getHeadCommit(Repository repository) throws Exception {
    try (Git git = new Git(repository)) {
        Iterable<RevCommit> history = git.log().setMaxCount(1).call();
        return history.iterator().next();
    }
}