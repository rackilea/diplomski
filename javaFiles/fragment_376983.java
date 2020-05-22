public class Test {

    public static void main(String[] args) throws Exception {
        FileSystemOptions opts = new FileSystemOptions();
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);
        FileSystemManager fileSystemManager = VFS.getManager();
        FileObject fileObject = fileSystemManager
                .resolveFile("sftp://user:password@host/",opts);

        FileObject temp = fileObject.resolveFile("/foo/faa/frog/");
        FileObject fileObjects[] = temp.getChildren();

        try {
            for (FileObject j : fileObjects) {

                System.out.println(j.getName().getBaseName());
                j.close();
            }
        } finally {
            fileObject.close();
            temp.close();
        }
    }
}