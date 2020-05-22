StringWriter outputWriter = new StringWriter();
    StreamResult result = new StreamResult( outputWriter );

    transformer.transform( text, result );  

    String outputAsString = outputWriter.getBuffer().toString();