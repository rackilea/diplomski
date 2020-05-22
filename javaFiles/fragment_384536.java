public class TestZipOrder {
    @Test
    public void testZipOrder() throws Exception {
        File file = new File("/Project/test.zip");
        ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        while ( (entry = zis.getNextEntry()) != null ) {
         System.out.println( entry.getName());
        }
    }
}