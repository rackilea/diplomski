RevObject object = walk.parseAny(objectIdOfTag);
if (object instanceof RevTag) {
    // annotated
} else if (object instanceof RevCommit) {
    // lightweight
} else {
    // invalid
}