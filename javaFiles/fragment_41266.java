public NormResult(List<String> normWords, List<String> unNormWords) {
    this.normWords = normWords;
    this.unNormWords = unNormWords;
}

public NormResult(List<String> normWords) {
    this(normWords, Collections.emptyList());
}