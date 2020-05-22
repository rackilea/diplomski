public class Streams {
    List<Pair<String, Long>> wordsWithManyVowels(Stream<String> words, int n) {
        return words
            .map(w -> Pair.of(w, (Words.vowels(w) - (w.length() - Words.vowels(w)))))
            .sorted(Comparator.comparingLong(Streams::vowelness).thenComparingInt(Streams::length))
            .limit(n)
            .collect(Collectors.toList());
    }

    static int length(Pair<String, Long> p) {
        return p.first().length();
    }

    static long vowelness(Pair<String, Long> p) {
        return -p.second();
    }
}