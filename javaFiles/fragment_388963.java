Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
perms.add(PosixFilePermission.OWNER_READ);
perms.add(PosixFilePermission.OWNER_WRITE);
perms.add(PosixFilePermission.OWNER_EXECUTE);
//add group permissions
perms.add(PosixFilePermission.GROUP_READ);
perms.add(PosixFilePermission.GROUP_WRITE);
perms.add(PosixFilePermission.GROUP_EXECUTE);

Path FilePathObject = Paths.get(fileDir.toString(),"fileRun.sh");
Files.setPosixFilePermissions(FilePathObject, perms);