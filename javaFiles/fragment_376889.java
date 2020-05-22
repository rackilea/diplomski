Iterator<String> filesIterator = this.getOutgoingFileName().iterator();
while(filesIterator.hasNext()) {
    String fileName = filesIterator.next();
    //TODO do your stuff
    filesIterator.remove(); //Removes it from the List<String> (getOutgoingFileName())
}