public void sendID() {
   DataOutputStreak dos = new DataOutputStream(getOuputStream());
   dos.writeUTF(this.getId());
}

public void receiveID() {
   DataInputStream dis = new DataInputStream(getInputStream());
   setId(dis.readUTF());
}