String cleartextAgainFile = "cleartextAgainSymm.txt";
cipher.init(Cipher.DECRYPT_MODE, secKey);
fis = new FileInputStream(ciphertextFile);
CipherInputStream cis = new CipherInputStream(fis, cipher);
BufferedReader read = new BufferedReader(new InputStreamReader(cis));
String str;
while((str=read.readLine())!=null){
   //do sth with the read line
}
read.close();