public class NumberPattern {

    private char[] maskChars;
    private Integer weight;

    public NumberPattern(String mask, Integer weight) {
        maskChars = mask.toCharArray();
        this.weight = weight;
    }

    public char[] getMaskChars() {
        return maskChars;
    }

    public void setMaskChars(char[] maskChars) {
        this.maskChars = maskChars;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}