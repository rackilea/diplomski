import 'dart:convert';
import 'dart:io';

import 'package:encrypt/encrypt.dart';

main() {

  perfomEncryptionTasks();
}

perfomEncryptionTasks() async {
  await encryptFile();
  await decryptFile();
}

encryptFile() async {
  File inFile = new File("video.mp4");
  File outFile = new File("videoenc.aes");

  bool outFileExists = await outFile.exists();

  if(!outFileExists){
    await outFile.create();
  }

  final videoFileContents = await inFile.readAsStringSync(encoding: latin1);

  final key = Key.fromUtf8('my 32 length key................');
  final iv = IV.fromLength(16);

  final encrypter = Encrypter(AES(key));

  final encrypted = encrypter.encrypt(videoFileContents, iv: iv);
  await outFile.writeAsBytes(encrypted.bytes);
}

decryptFile() async {
  File inFile = new File("videoenc.aes");
  File outFile = new File("videodec.mp4");

  bool outFileExists = await outFile.exists();

  if(!outFileExists){
    await outFile.create();
  }

  final videoFileContents = await inFile.readAsBytesSync();

  final key = Key.fromUtf8('my 32 length key................');
  final iv = IV.fromLength(16);

  final encrypter = Encrypter(AES(key));

  final encryptedFile = Encrypted(videoFileContents);
  final decrypted = encrypter.decrypt(encryptedFile, iv: iv);

  final decryptedBytes = latin1.encode(decrypted);
  await outFile.writeAsBytes(decryptedBytes);

}