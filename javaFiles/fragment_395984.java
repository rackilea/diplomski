/**
 * @return the authenticated principal name
 */
 public String getUser() {
 Session session = getSession();
 Serializable value = session.getAttribute(SSO_USER_NAME);
 return value + BLANK_STRING;
 }