byte[] output = new byte[len];
int pos = 0;
for(byte[] data: arrayList) {
    System.arrayscopy(data,0,output,pos,data.length);
    pos+=data.length;
}