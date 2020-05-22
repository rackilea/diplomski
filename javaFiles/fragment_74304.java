List<byte[]> list = Arrays.asList("abc".getBytes(), "def".getBytes());
byte[] result = list.stream()
    .collect(
        () -> new ByteArrayOutputStream(),
        (b, e) -> {
            try {
                b.write(e);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        },
        (a, b) -> {}).toByteArray();
System.out.println(new String(result));
// -> abcdef