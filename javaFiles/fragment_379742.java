private void extractFromSentReader(ChunkedSentenceReader reader)
        throws ExtractorException {
    long start;

    ChunkedSentenceIterator sentenceIt = reader.iterator();

    while (sentenceIt.hasNext()) {
        // get the next chunked sentence
        ChunkedSentence sent = sentenceIt.next();
        chunkTime += sentenceIt.getLastComputeTime();

        numSents++;

        // make the extractions
        start = System.nanoTime();
        Iterable<ChunkedBinaryExtraction> extractions = extractor
                .extract(sent);
        extractTime += System.nanoTime() - start;

        for (ChunkedBinaryExtraction extr : extractions) {
            numExtrs++;

            // run the confidence function
            start = System.nanoTime();
            double conf = getConf(extr);
            confTime += System.nanoTime() - start;

            NormalizedBinaryExtraction extrNorm = normalizer
                    .normalize(extr);
            printExtr(extrNorm, conf);
        }
        if (numSents % messageEvery == 0)
            summary();
    }
}

private void printExtr(NormalizedBinaryExtraction extr, double conf) {
    String arg1 = extr.getArgument1().toString();
    String rel = extr.getRelation().toString();
    String arg2 = extr.getArgument2().toString();

    ChunkedSentence sent = extr.getSentence();
    String toks = sent.getTokensAsString();
    String pos = sent.getPosTagsAsString();
    String chunks = sent.getChunkTagsAsString();
    String arg1Norm = extr.getArgument1Norm().toString();
    String relNorm = extr.getRelationNorm().toString();
    String arg2Norm = extr.getArgument2Norm().toString();

    Range arg1Range = extr.getArgument1().getRange();
    Range relRange = extr.getRelation().getRange();
    Range arg2Range = extr.getArgument2().getRange();
    String a1s = String.valueOf(arg1Range.getStart());
    String a1e = String.valueOf(arg1Range.getEnd());
    String rs = String.valueOf(relRange.getStart());
    String re = String.valueOf(relRange.getEnd());
    String a2s = String.valueOf(arg2Range.getStart());
    String a2e = String.valueOf(arg2Range.getEnd());

    String row = Joiner.on("\t").join(
            new String[] { currentFile, String.valueOf(numSents), arg1,
                    rel, arg2, a1s, a1e, rs, re, a2s, a2e,
                    String.valueOf(conf), toks, pos, chunks, arg1Norm,
                    relNorm, arg2Norm });

    System.out.println(row);
}