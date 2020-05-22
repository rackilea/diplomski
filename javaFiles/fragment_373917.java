class Test {
    public static void main(String[] args) throws Exception {

        byte[] bytes = "hello xyz world.".getBytes("UTF-8");

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        byte[] search = "xyz".getBytes("UTF-8");
        byte[] replacement = "abc".getBytes("UTF-8");

        InputStream ris = new ReplacingInputStream(bis, search, replacement);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int b;
        while (-1 != (b = ris.read()))
            bos.write(b);

        System.out.println(new String(bos.toByteArray()));

    }
}