byte[] byteArray;

    byte[] firstPart = new byte[]{0,0,0};
    byte secondPart = 0; //whatever your Operation Group value is
    byte thirdPart = 0; //whatever your Packet type is value is

    String lastParrtString = "blaBLAbla";
    final String encoding = "UTF8"; //establish an encoding for the string representing the last part

    byte[] lastPart = lastParrtString.getBytes(encoding);

    int byteArrayLength = firstPart.length + 1 + 1 +  lastPart.length;              
    byteArray = new byte[byteArrayLength];

    int pos = 0;
    for(/*initialized above*/;pos < firstPart.length; pos++) {
        byteArray[pos] = firstPart[pos];
    }
    byteArray[++pos] = secondPart;
    byteArray[++pos] = thirdPart;

    int tempPos = 0;
    for( ;pos < byteArray.length; pos++) {
        byteArray[pos] = lastPart[tempPos++];
    }

    System.out.println(Arrays.toString(byteArray));
    System.out.println(Arrays.toString(lastPart));