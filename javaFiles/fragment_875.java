/**
     * Read a mapping as an application resource using the convention that a class
     * named <tt>foo.bar.Foo</tt> is mapped by a file <tt>foo/bar/Foo.hbm.xml</tt>
     * which can be resolved as a classpath resource.
     *
     * @param persistentClass The mapped class
     * @return this (for method chaining purposes)
     * @throws MappingException Indicates problems locating the resource or
     * processing the contained mapping document.
     */
    public Configuration addClass(Class persistentClass) throws MappingException {
        String mappingResourceName = persistentClass.getName().replace( '.', '/' ) + ".hbm.xml";
        LOG.readingMappingsFromResource( mappingResourceName );
        return addResource( mappingResourceName, persistentClass.getClassLoader() );
    }

    /**
     * Read metadata from the annotations associated with this class.
     *
     * @param annotatedClass The class containing annotations
     *
     * @return this (for method chaining)
     */
    @SuppressWarnings({ "unchecked" })
    public Configuration addAnnotatedClass(Class annotatedClass) {
        XClass xClass = reflectionManager.toXClass( annotatedClass );
        metadataSourceQueue.add( xClass );
        return this;
    }