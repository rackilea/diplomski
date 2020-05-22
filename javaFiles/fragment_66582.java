public enum STYLE {
    ELEMENT1(0), 
    A_R (2) {
        @Override
        public String printableName() {
            return "A_R";
        } 
    };

    public String printableName() {
        return name();
    } 
}