OutputStream output = new OutputStream() {
    private StringBuilder string = new StringBuilder();
    @Override
    public void write(int b) throws IOException {
        this.string.append((char) b );
    }

    public String toString(){
        return this.string.toString();
    }
};
RevCommit headCommit = getHeadCommit(repository);
RevCommit diffWith = headCommit.getParent(0);
try (DiffFormatter diffFormatter = new DiffFormatter(output)) {
    diffFormatter.setRepository(repository);
    for (DiffEntry entry : diffFormatter.scan(diffWith, headCommit)) {
        diffFormatter.format(diffFormatter.toFileHeader(entry));
    }
String strings = output.toString();
System.out.println(strings);