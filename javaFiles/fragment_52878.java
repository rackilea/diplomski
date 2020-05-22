public Form (Object objRef) {
    Field[] fields = objRef.getClass().getFields();
    if(objRef instanceof Form.FormLayout) {
        inputs = ((FormLayout) objRef).getLayout();
    }
    else {
        inputs = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            inputs.add(new Input(fields[i].getName(), FormInputs.get(fields[i].getType())));
        }
    }
}