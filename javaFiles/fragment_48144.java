List<IExtendedFileSpec> extfiles = server.getExtendedFiles(changelistPendingFiles,
    -1,
    -1,
    -1,
    new FileStatOutputOptions(false, false, false, false, false, true),
    null);

for(IExtendedFileSpec extfile : extfiles) {        
    System.out.println(extfile.isUnresolved());
}