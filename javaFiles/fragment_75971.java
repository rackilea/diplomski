public class ModifyRequest extends ActionSupport{

    private String exampleParameterFromJSP;        

    public String getExampleParameterFromJSP() {
        return exampleParameterFromJSP;
    }
    public void setExampleParameterFromJSP(String exampleParameterFromJSP) {
        this.exampleParameterFromJSP = exampleParameterFromJSP;
    }


    @Override
    public String execute() throws Exception {    
        if("1337".equals(exampleParameterFromJSP)){
            addActionMessage("SUCCESS !! So long and thanks for all the fish!");
            return SUCCESS;
        } else{                
            addActionError("ERROR !! You must write '1337' to make it works!");
            return ERROR;
        }

    }

}