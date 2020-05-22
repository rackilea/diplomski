EditorialBlock findBlockByID(final List<Block> contentBlocks, final String identifier) {
    return Observable.from(contentBlocks)
            .cast(EditorialBlock.class)
            .filter(x -> x.getIdentifier().equals(identifier))
            .toBlocking()
            .firstOrDefault(null);
}