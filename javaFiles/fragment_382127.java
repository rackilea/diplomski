....
else if (OAuth2AccessToken.EXPIRES_IN.equals(name)) {
    try {
        expiresIn = jp.getLongValue();
    } catch (JsonParseException e) {
        expiresIn = Long.valueOf(jp.getText());
    }
}
....