@PostAuthorize("hasPermission(returnObject, 'READ')")
public FileObject readFileObject(String path) {
    // return the file object from DAO
}

@PreAuthorize("hasPermission(#fileObj, 'WRITE')")
public void writeFileObject(FileObject fileObj) {
    // write the file object, security check made at this point
}