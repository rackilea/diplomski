public Integer visitDirectory (DirectoryNode d) {
  for ( Iterator<FileSystemNode> iterator = d.iterator(); iterator.hasNext(); ) {
    FileSystemNode fsn = iterator.next();
    fsn.getSize();
  }
}