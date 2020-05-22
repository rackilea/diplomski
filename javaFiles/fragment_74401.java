DocsAndPositionsEnum payloads = null;
TermsEnum iterator = null;

Terms termVector = reader.getTermVector(docId, "field");
iterator = termVector.iterator(iterator);

while ((ref = iterator.next()) != null) {
    payloads = iterator.docsAndPositions(null, payloads, DocsAndPositionsEnum.FLAG_PAYLOADS);

    while (payloads.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
        int freq = payloads.freq();
        for (int i = 0; i < freq; i++) {
            payloads.nextPosition();

            BytesRef payload = payloads.getPayload();
            // do something with the payload
        }
    }
}