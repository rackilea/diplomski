public class FieldLengthChecker extends Thread {

    public void run() {
        while(true) {
           try {
                String username = authUserField.getText();
                if (username.length() > 3) {
                    authLoginButton.setEnabled(true);
                } else {
                    authLoginButton.setEnabled(false);
                }
            } catch (NullPointerException e) {
                // handle exception
            }
        }
    }
}