public class RegisterController {

    public void regHandle(UserDataObject user1){

        ValidateRegisterInputController validate = new ValidateRegisterInputController();
        validate.validateInputHandle(user1); 

        OracleUserManagement usermanagement = OracleUserManagement.getInstance();
        if (usermanagement.storeUser(user1) == false) { 
            errorUsernameDuplicate(); }

    }

    void errorUsernameDuplicate() {
        RegisterGUI.errorUsernameDuplicate();
    }
}