String[] hexArray = new String[byteArray.length];
for(int index = 0; index < byteArray.length; index++) {
    hexArray[index] = Integer.toHexString(byteArray[index]);
    // maybe you have to convert your byte to int before this can be done
    // (cannot check reight now)
}