// ...

ByteArrayOutputStream baos = new ByteArrayOutputStream();
out = new PrintStream(baos);

// ...

ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());

// use in to read the data