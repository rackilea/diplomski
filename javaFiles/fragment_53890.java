JsonFactory factory = new JsonFactory();
JsonParser jp = null;
try {
    jp = factory.createJsonParser(response);
} catch (JsonParseException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
    System.out.println("There was an error while setting jp to factory.createJsonParser(response). Error message is: " + e1.getMessage());
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
    System.out.println("There was an error while setting jp to factory.createJsonParser(response). Error message is: " + e1.getMessage());
}

if(jp != null) {
try {

    if (jp.nextToken() != JsonToken.START_OBJECT) {
    throw new IOException("Server didn't return any data");
    }

    while (jp.nextToken() != JsonToken.END_OBJECT) {
    String fieldName = jp.getCurrentName();
    jp.nextToken();
    if (fieldName.equals("messagelast")) {
        setLastMessageId(jp.getText());
    } else if (fieldName.equals("pollid")) {
        setPoollid(jp.getIntValue());
    } else if (fieldName.equals("messagebase")) {
        setMessageBase(jp.getText());
    } else if (fieldName.equals("error")) {
        setError(jp.getText());
    }
    }
    jp.close();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (NullPointerException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

try {
    jp.close();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}
}