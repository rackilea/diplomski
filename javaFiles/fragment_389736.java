public interface FileMerger implements Serializable {
    public void merge(String path, List<File> files, OutputStream out) throws IOException;
}

public class MergeCopy extends DefaultTask {
    private File outputDir;
    private List<FileTree> fileTrees = []

    @TaskInput
    FileMerger merger

    @OutputDirectory
    File getOutputDir() {
       return outputDir
    }

    @InputFiles
    List<FileTree> getFileTrees() {
       return fileTrees
    }

    void from(FileTree fileTree) {
        fileTrees.add(fileTree)
    }

    void into(Object into) {
        outputDir = project.file(into)
    }

    @TaskAction
    void copyAndMerge() {
       Map<String, List<File>> fileMap = [:]
       FileTree allTree = project.files().asFileTree
       fileTrees.each { FileTree fileTree ->
           allTree = allTree.plus(fileTree)
           fileTree.visit { FileVisitDetails fvd ->
               String path = fvd.path.path
               List<File> matches = fileMap[path] ?: []
               matches << fvd.file
               fileMap[path] = matches
           }
       }
       Set<String> dupPaths = [] as Set
       Set<String> nonDupPaths = [] as Set
       fileMap.each { String path, List<File> matches ->
           if (matches.size() > 1) {
              dupPaths << path
           } else {
              nonDupPaths << path
           }
       }
       FileTree nonDups = allTree.matching {
           exclude dupPaths
       }
       project.copy {
           from nonDups
           into outputDir
       }
       for (String dupPath : dupPaths) {
           List<File> matches = fileMap[dupPath]
           File outFile = new File(outputDir, dupPath)
           outFile.parentFile.mkdirs()
           try (OutputStream out = new FileOutputStream(outFile)) {
               merger.merge(dupPath, matches, out)
               out.flush()
           }
       }
    }
}