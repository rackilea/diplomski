static InputStream getInputStream(File zip, String entry) throws IOException {
    ZipInputStream zin = new ZipInputStream(new FileInputStream(zip));
    for (ZipEntry e; (e = zin.getNextEntry()) != null;) {
        if (e.getName().equals(entry)) {
            return zin;
        }
    }
    throw new EOFException("Cannot find " + entry);
}

public static void main(String[] args) throws Exception {
    InputStream in = getInputStream(new File("f:/1.zip"), "launch4j/LICENSE.txt");
    Scanner sc = new Scanner(in);
    while(sc.hasNextLine()) {
        System.out.println(sc.nextLine());
    }
    in.close();
}