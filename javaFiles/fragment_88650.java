OutputStream out_bytes = new FileOutputStream("intFile.bin");
out_bytes.write(1);
out_bytes.write(2);
out_bytes.write(3);
out_bytes.write(4);
out_bytes.close();