List<YourElement> yourList;
...
Iterator<YourElement> iterator = yourList.iterator();
while(iterator.hasNext()) {
    final YourElement yourElement = iterator.next();        
    // Do whatever with yourElement
    if (iterator.hasNext()) {
        // Do whatever if there's a next element to yourElement
    }
}