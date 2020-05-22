List<List<IStitchable>> listOfEnvelopes = new ArrayList<>();     
List<IStitchable> statementsInEnvelope = new ArrayList<>();
AtomicInteger totalPages = new AtomicInteger();

byteArrays.stream().forEach(byteArray -> {
  totalPages.addAndGet(getPagesInDocument(byteArray));

  if(totalPages.get() / 2 > MAX_SHEETS_FOR_OVERSIZE_ENVELOPE){
    totalPages.set(0);
    listOfEnvelopes.add(new ArrayList<>(statementsInEnvelope));
    statementsInEnvelope.clear();
  }
  statementsInEnvelope.add(createStitchableFromSnapshot(byteArray));
});