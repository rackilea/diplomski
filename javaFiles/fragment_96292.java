byte[] data = getTheDataFromSomewhere();
long checksum = 0;
for (int i = 0; i < data.length; i++) {
  checksum += (data[i] & 0xFF);
}
checksum = checksum & 0xFFFFFFFFL; // truncate to 4 byte