public class Login extends javax.swing.JDialog{
    // Get saved info and set the textbox text
    public Login(){
        String userName = pref.get("user", "");
        if(!userName.equals("")){
            this.user.setText(userName);
        }
        String passName = pref.get("pass", "");
        if(!passName.equals("")){
            this.pass.setText(passName);
        }
    }

    // Run on login button click
    public void login(){
        String p = new String(pass.getPassword());
        DoLogin log = new DoLogin(user.getText(), p);
        log.execute();
    }

    // Process in background
    public class DoLogin extends SwingWorker{
        public void done(){
            // On successfull login save user data
            pref.put("user", this.strUser);
            pref.put("pass", this.strPass);
        }

        public String doInBackground(){
            // Process login
        }
    }
}