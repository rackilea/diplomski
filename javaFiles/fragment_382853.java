final Validator validator = schema.newValidator();
validator.setErrorHandler(new ErrorHandler() {

    public void warning(SAXParseException saxpe) throws SAXException {
        //ignore, log or whatever
    }

    public void error(SAXParseException saxpe) throws SAXException {
        throw saxpe;
    }

    public void fatalError(SAXParseException saxpe) throws SAXException {
        //parsing cannot continue
        throw saxpe;
    }
});
final Source source = new StreamSource(new File("my.xml"));
validator.validate(source);