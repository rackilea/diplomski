// access each file by name
File file = request.getFile('documentFile1')

// or iterate through them
request.fileNames.each {
    File file = request.getFile(it)
}