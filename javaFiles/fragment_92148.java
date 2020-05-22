public enum Towns {
    Rome("rome")
    , Napoli("napoli")
    , Modena("modena");

    private String desc;
    Towns(String desc) {
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }
}