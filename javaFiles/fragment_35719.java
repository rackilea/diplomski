@Data
class IntermediateResult1 {
    private DataType1 d1;
    private DataType2 d2;
}

@Data
class IntermediateResult2 {
    public IntermediateResult2(IntermediateResult1 i1, DataType3 d3) {
        this.d1 = i1.getD1();
        this.d2 = i1.getD2();
        this.d3 = d3;
    }
    private DataType1 d1;
    private DataType2 d2;
    private DataType3 d3;
}