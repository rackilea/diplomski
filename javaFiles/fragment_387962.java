tf.setErrorListener(new ErrorListener() {

        @Override
        public void warning(TransformerException exception) throws TransformerException {
            ...
        }

        @Override
        public void fatalError(TransformerException exception) throws TransformerException {
            ...

        }

        @Override
        public void error(TransformerException exception) throws TransformerException {
            ...

        }
    });