/**
     * Retrieves selected attributes associated with a named object.
     * See {@link #getAttributes(Name, String[])} for details.
     *
     * @param name
     *          The name of the object from which to retrieve attributes
     * @param attrIds
     *          the identifiers of the attributes to retrieve.
     *          null indicates that all attributes should be retrieved;
     *          an empty array indicates that none should be retrieved.
     * @return  the requested attributes; never null
     *
     * @throws  NamingException if a naming exception is encountered
     */
    public Attributes getAttributes(String name, String[] attrIds)
            throws NamingException;