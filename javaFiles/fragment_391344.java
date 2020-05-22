if (context.getInputSplit() instanceof FileSplit) {
    FileSplit fileSplit = (FileSplit) context.getInputSplit();
    Path inputPath = fileSplit.getPath();
    String fileId = ... //parse inputPath into a file id
    ...
}