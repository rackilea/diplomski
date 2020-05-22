public class Empaction extends ActionSupport implements ModelDriven<Empmodel> {

    private static final long serialVersionUID = 1L;
    Empmodel modelobj = new Empmodel();

    public String execute() throws Exception {

        Empdao empdao = new Empdao();

        int queryResult = empdao.registration(modelobj);

        if (queryResult == 0) {
            addActionError("it is a dublicate entry please enter anothe id");
            return ERROR;
        } else {

            return SUCCESS;
        }
    }

    @Override
    public Empmodel getModel() {
        return modelobj;
    }
}