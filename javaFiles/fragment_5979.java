DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    long l = 2194;
    String nume = "The file name";

    dos.writeUTF("FILE1");
    dos.flush();
    dos.writeLong(l);
    dos.flush();
    dos.writeUTF(nume);
    dos.flush();
    System.out.println("SERVER: fisier trimis" + System.lineSeparator());