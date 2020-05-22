public Page1(Pageparameters parameters) {
    super(parameters);

    String value = parameters.get("magicProperty").toString();
    if (value != null && isValid(value)) {
       Serializable key = createKey(value);
       Session session = getSession();
       session.setAttribute("key", key);
       session.bind();
       throw new RestartResponseException(Page2.class);
    }
}