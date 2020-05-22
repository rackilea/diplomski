public static void removeLines(final File targetFile,
    final Charset charSet,
    final Collection<Integer> lineNumbers) throws IOException{
    final List<String> lines = Files.readLines(targetFile, charSet);
    // line numbers need to be sorted in reverse.
    // if they are, you can replace everything from Ordering until )){
    // with 'lineNumbers){'
    for(final Integer lineNumber : Ordering
        .natural()
        .reverse()
        .immutableSortedCopy(lineNumbers)){
        lines.remove(lineNumber.intValue());
    }
    Files.write(Joiner.on('\n').join(lines), targetFile, charSet);
}