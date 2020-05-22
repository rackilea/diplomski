static private void Criptografar(KeyPair chaves, Cipher ci){
    try {
        PublicKey publica = chaves.getPublic();
        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.ENCRYPT_MODE, publica);
        FileInputStream entrada_arq_c = new FileInputStream("arquivo.txt");
        FileOutputStream saida_arq_c = new FileOutputStream("criptografado.txt");
        processFile(ci, entrada_arq_c, saida_arq_c);
    }
    catch(Exception e){
        System.out.println("Erro ao criptografar.");
    }
}