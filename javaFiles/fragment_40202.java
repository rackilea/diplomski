CLASSA Ccs = new CLASSA(gsm);
@Override
public void init() {
    getFirstCompanion();

    getVariables();

}

private void getVariables() {
    classChoice = Ccs.getClassChoice();

    System.out.println("Init, class is " + classChoice); //here, this returns as nothing, not     null, nothing

}