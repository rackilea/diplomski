class ContainsInnerEnum {
    MYOPTIONS temp;

    public enum MYOPTIONS {
        OPTION1, OPTION2, OPTION3;
    } 
}

class EnumTester {
    public void test () {
        ContainsInnerEnum ie = new ContainsInnerEnum ();
        // fail:
        // ie.temp = MYOPTIONS.OPTION1;
        // works:
        ie.temp = ContainsInnerEnum.MYOPTIONS.OPTION1;
    }       
}