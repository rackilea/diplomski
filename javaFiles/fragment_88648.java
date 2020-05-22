DataOutputStream out = new DataOutputStream(new FileOutputStream("intFile.bin"));
out.writeInt(123456789);
out.close();

DataInputStream in = new DataInputStream(new FileInputStream("intFile.bin"));
System.out.println(in.readInt());
in.close();