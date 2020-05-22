JsonParser parser = new JsonFactory().createJsonParser(new File("c:\\big.json"));
while (parser.nextToken() != JsonToken.NOT_AVAILABLE) {
    if ("id".equals(parser.getCurrentName())) {
        parser.nextToken();
        String value = parser.getText();
        if (value.equals("b3d888b1-c4f0-4337-87a3-d51961d81c0b")) {
            System.out.println("id is found: " + value);
        }
    }
}
parser.close();