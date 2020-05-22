ParseContext context = new ParseContext();
context.set(PasswordProvider.class, new PasswordProvider() {
     public String getPassword(Metadata metadata) {
        return "password";
    }
});
parser.parse(stream, handler, metadata, context);