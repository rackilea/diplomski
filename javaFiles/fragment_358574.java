FileInputStream fis1 = new FileInputStream("/tmp/adb.log");
FileDescriptor fd = fis1.getFD();
FileInputStream fis2 = new FileInputStream(fd);
System.out.println(fd.valid());
fis1.close();
System.out.println(fd.valid());
fis2.close();
System.out.println(fd.valid());