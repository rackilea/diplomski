dos = new DataOutputStream(s.getOutputStream());

for(int i = 0; i < logList.length; ++i){
    String backupPayload = invertLogStringToJson(logList[i]);
    dos.writeUTF(backupPayload);
}
dos.flush();

dos.close();