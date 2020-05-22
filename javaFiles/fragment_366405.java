ZipFile zipFile = new ZipFile("???.zip");

int count = 0;

Enumeration<? extends ZipEntry> entries = zipFile.entries();
while (entries.hasMoreElements()) {
    ZipEntry entry = entries.nextElement();
    if (entry.getName().contains("idle")) count++;
}