public enum Constants {

    VAL_CHAR {
        public boolean validate() {
            return validateChar();
        }
    },
    VAL_DATE {
        public boolean validate() {
            return validateDate();
        }
    },
    ...
    ;

    public abstract boolean validate();

}