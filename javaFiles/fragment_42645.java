public class Operations {
    private ABC abcInst;
    private DE deInst;
    private FGH fghInst;

    protected Operations(ABC abc, DE de, FGH fgh) {
        this.abcInst = abc;
        this.deInst = de;
        this.fghInst = fgh;
    }

    public ABC getABC() { return abcInst; }
    public DE getDE() { return deInst; }
    public FGH getFGH() { return fghInst; }
}