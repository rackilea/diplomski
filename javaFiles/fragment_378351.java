byte[] byteVal = value.getBytes;
Uid.List uids= Uid.List.parseFrom(byteVal); 
int count = uids.getUIDCount(); 
for (int i = 0; i< count; i++){ 
    String uidStr = uids.getUID(i).toString();
    system.out.println(uidStr);
}