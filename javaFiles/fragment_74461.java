Socket socket = ...;
DataInputStream dis = new DataInputStream(socket.getInputStream());
DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

/* Write a short */
short out = 255;
dos.writeShort(out);

/* Read a short */
short in = dis.readShort();