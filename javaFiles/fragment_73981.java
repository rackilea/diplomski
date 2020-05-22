File cryptedData = new File("/tmp/encrypted");
buffer = new byte[(int) cryptedData.length()];

in = new DataInputStream(new FileInputStream(cryptedData));
in.readFully(buffer);
in.close();