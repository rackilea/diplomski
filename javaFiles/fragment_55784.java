Picture stegoObject = new Picture("Earth.bmp");
HideMessage stego = new HideMessage();
stego.encodeMessage(stegoObject, bitArray);
Picture decodeObject = new Picture("SecretMessage.bmp");
System.out.println("Now Decoding");
stego.decodeMessage(decodeObject);