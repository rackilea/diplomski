public void sendImage(File file) {
    try {
        DataOutputStream out = new DataOutputStream(
                socket.getOutputStream());
        out.writeChar('I'); // as image,
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        ByteArrayOutputStream ao = new ByteArrayOutputStream();
        int read = 0;
        byte[] buf = new byte[1024];
        while ((read = dis.read(buf)) > -1) {
            ao.write(buf, 0, read);
        }
        out.writeLong(ao.size());
        out.write(ao.toByteArray());
        out.flush();
        out.close();
        dis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}