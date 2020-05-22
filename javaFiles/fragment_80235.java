FileSystem[] fileSystemList = this.proxy.getFileSystemList();
for (int i = 0; i < fileSystemList.length; i++) {
    FileSystem fs = fileSystemList[i];
    if (fs.getType() == FileSystem.TYPE_LOCAL_DISK){
    FileSystemUsage usage = this.sigar.getFileSystemUsage(fs.getDirName());

    String devName = fs.getDevName();

    long read = usage.getDiskReadBytes();
    long write = usage.getDiskWriteBytes();


    }

}