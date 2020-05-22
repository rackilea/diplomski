public class WINDOWPLACEMENT extends Structure {
    public WINDOWPLACEMENT() {
        this.length = size();
    }
    public List getFieldOrder() {
        return Arrays.asList("length", "flags", "showCmd", "ptMinPosition", "ptMaxPosition", "rcNormalPosition");
    }
    // ...
}