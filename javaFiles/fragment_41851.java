Metadata metadata = ImageMetadataReader.readMetadata(file);
Iterable<Directory> directories = metadata.getDirectories();
Iterator<Directory> iterator = directories.iterator();
while(iterator.hasNext()) {
    Directory dir = iterator.next();
    Collection<Tag> tags = dir.getTags();
    for(Tag tag: tags) {
        System.out.println(tag.getTagName() + "  " + tag.getDescription() + " " + tag.getTagTypeHex());
    }
}