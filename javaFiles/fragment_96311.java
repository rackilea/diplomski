@Test
        public void FileFinding_Right_One() {
        String file = getClass().getClassLoader().getResource("Koala.jpg").getFile();
        System.out.println(file.substring(1,file.length()));
}
    @Test
        public void File_Finding_Right_Second
        File f = new File("src/test/resources/Koala.jpg");
        System.out.println(f.getAbsolutePath());
}