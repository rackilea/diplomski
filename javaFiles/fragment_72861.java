MutableInt recordCounter = new MutableInt();
try {
    Iterators.partition(myObjects.iterator(), 1000)
             .forEachRemaining((chunk) -> {
                      //process each chunk
                      ...
                      recordCounter.add(chunk.size());
             });
} catch (Exception e) {
    throw new MyRuntimeException("Failure streaming...", e);
} finally {
    myObjects.close();
}

return recordCounter.getValue();