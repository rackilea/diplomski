public class RegistrationAction extends ActionSupport 
                             implements SessionAware,Preparable ,ModelDriven {

    public String execute(){
        MyEjb ejb = new CdiUtil().lookup(MyEjb.class);
        System.out.println(ejb.find(1L));
        return SUCCESS;
    }

    /* your other stuff here */
}