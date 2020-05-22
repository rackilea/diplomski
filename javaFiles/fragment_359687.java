class Pojo {
    private String sampleNumber = "1234";

    @JsonSerialize(using = ForceIntSerializer.class)
    public String getSampleNumber() {
        return sampleNumber;
    }
}