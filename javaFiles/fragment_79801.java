HashMap<String, Integer> counter = bigrams.get(readBigrams);
if (null == counter) {
    counter = new HashMap<String, Integer>();
    bigrams.put(readBigrams, counter);
}
Integer count = counter.get(read2);
counter.put(read2, count == null ? 1 : count + 1);