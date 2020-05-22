@Override
protected void processImageWithoutPicturesManager(Element currentBlock,
    boolean inlined, Picture picture)
{
    // no default implementation -- skip
    currentBlock.appendChild(htmlDocumentFacade.document
    .createComment("Image link to '"
    + picture.suggestFullFileName() + "' can be here"));
}