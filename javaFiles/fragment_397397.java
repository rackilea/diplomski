XMLGrammarPoolImpl pool = new XMLGrammarPoolImpl();
pool.putGrammar(grammar);

XMLSchema11Factory factory = new XMLSchema11Factory();
Schema schema = factory.newSchema(pool);

Validator validator = schema.newValidator();

DOMSource source = new DOMSource(document);
validator.validate(source);