String json = (object as JSON).toString()
new RestBuilder(
        ...
        // workaround for https://github.com/grails/grails-data-mapping/issues/864
        registerConverters: false
    )
    .put(...) {
        ...
        body json
    }