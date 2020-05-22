public void encrypt(Encrypter enc) {
   byte[] programbytes = enc.encrypt(program);
}

public void encrypt(Decrypter dec) {
   program = dec.decrypt(programbytes);
}