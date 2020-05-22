@Immutable
public final MyMessageClass {

    private final String message;
    private final Date dateLastChange;
    private final String identifier;

    public MyClass(final MyMessageClass.Builder builder){
        this.message = builder.message;
        this.dataLastChange = builder.dataLastChange;
        this.identifier = builder.identifier;
    } 

    public Date lastChange() {
        return new Date(dateLastChange.getTime());
    }

    public String messageValue(){
        return message;
    }

    public String identifier(){
        return identifier;
    }

    public static final class Builder {
        private String message;
        private final Date dateLastChange = new Date();
        private String identifier;

        public Builder message(final String message) {
            this.message = message;
            return this;
        }

        public String message() {
            return message;
        }

        public Builder identifier(final String identifier) {
            this.identifier = identifier;
            return this;
        }

        public String identifier() {
            return identifier;
        }

        public Date lastChange() {
            return new Date(dateLastChange.getTime());
        }

        public MyMessageClass build() {
            return new MyMessageClass(this);
        }
    }
}