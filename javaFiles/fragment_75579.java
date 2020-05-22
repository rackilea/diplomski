public abstract class NewUserWindow<T, F extends WebserviceIntegration> extends Window {

    public NewUserWindow(T objOne, F objTwo) {

        F f = createF();
        saveConnectedBean(f);
    }

    public abstract F createF();

    public void saveConnectedBean(F bean) throws MyException{
        //...
    }
}