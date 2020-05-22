public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        TokenStream stream = (TokenStream) getPreviousTokenStream();

        if (stream == null) {
            stream = new AttachmentNameTokenizer(reader);
            if (stemmTokens)
                stream = new SnowballFilter(stream, name);
            setPreviousTokenStream(stream); // --------------->  problem was here 
        } else if (stream instanceof Tokenizer) {
            ( (Tokenizer) stream ).reset(reader); 
        }

        return stream;
    }