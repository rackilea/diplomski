ByteArrayOutputStream out = new ByteArrayOutputStream();

fillTheOutput(out);

ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

pass1(in);
in.reset();
pass2(in);