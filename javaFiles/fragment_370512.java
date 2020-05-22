dos = new DataOutputStream(s.getOutputStream());

// maybe other things first...

dos.writeInt(logList.length);
for(int i = 0; i < logList.length; ++i){
    String backupPayload = invertLogStringToJson(logList[i]);
    dos.writeUTF(backupPayload);
}
dos.flush();

// maybe other things next...

dos.close();