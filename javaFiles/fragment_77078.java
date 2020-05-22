public class Main {
        AESAlgorithm aesAlgo;
        private byte[] keyValue = new byte[]{'t','h','e','b','e','s','t','s','e','c','r','e','t','k','e','y'};
        public Main(){
            //initComponents();
            //here we passed key to constructor
            aesAlgo = new AESAlgorithm(keyValue);
        }

        private void aesEncryption(){
            try{

                String plainText = inputArea.getText();
                String encryptedText = aesAlgo.encrypt(plainText);
                outputArea.setText(encryptedText);

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }