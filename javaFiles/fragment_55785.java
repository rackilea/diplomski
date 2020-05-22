/* encode */
Picture pic_to_steg = new Picture("foo.bmp");
HideMessage stego = new HideMessage();
Picture secret = stego.encodeMessage(pic_to_steg, bitArray);
secret.write("SecretMessage.bmp");

/* decode */
Picture pic_with_message = new Picture("SecretMessage.bmp");
int[] hidden = stego.decodeMessage(pic_with_message);

/* output `hidden` and compare against `bitArray` */