class Pojo {
    private String sampleNumber = "1234";

    public Integer getSampleNumber() {
        return Integer.parseInt(sampleNumber);
    }

    @JsonIgnore
    public String getSampleNumberString() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }
}