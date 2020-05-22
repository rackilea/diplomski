zipout = ...

ZipEntry z1 = ...
zipout.putNextEntry(z1);
// write something to zipout
zipout.closeEntry();

ZipEntry z2 = ...
zipout.putNextEntry(z2);
// write something to zipout
zipout.closeEntry();

//...

ZipEntry zN = ...
zipout.putNextEntry(zN);
// write something to zipout
zipout.closeEntry();


zipout.close();