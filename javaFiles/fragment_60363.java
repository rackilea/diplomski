Optional<Album> testAlbum = Optional.ofNullable((Album) testMap.get(testField));
final List <Album> testList = new ArrayList();
testAlbum.ifPresent(theAlbum -> {
    if(!isFree || applyFreeFilter((Album) theAlbum))
        testList.add((Album) theAlbum);
});