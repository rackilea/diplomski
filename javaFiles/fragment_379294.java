public class MyBean {

    private String sDesignation;
    private int iValue;

    public MyBean() {
    }

    public MyBean(String sDesignation, int iValue) {
        this.sDesignation = sDesignation;
        this.iValue = iValue;
    }

    public String getDesignation() {
        return sDesignation;
    }

    public int getValue() {
        return iValue;
    }

}