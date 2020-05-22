final DataOutputStream out = 

public void sendStr(String str) throws IOException {
    out.writeUTF(str);
}

final DataInputStream in = 

public String getStr() throws IOException {//blocking call
    return in.readUTF(); // will return exactly on string.
}