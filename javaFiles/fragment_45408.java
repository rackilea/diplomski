Scanner sc = new Scanner(System.in);
        try{
            String text="";
            String key="Bar12345Bar12345";

            System.out.print("Input Text>> ");
            text= sc.nextLine();
            java.security.Key aesKey = new SecretKeySpec(key.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            String outputString = Base64.getEncoder().encodeToString(encrypted);

            System.out.println(outputString);

            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(outputString.getBytes())));
                System.out.println(decrypted);
            }catch(Exception e){
                e.printStackTrace();
            }