ODataQueryBuilder builder = 
    ODataQueryBuilder
    .withEntity(...)
    .errorHandler(new ODataVdmErrorResultHandler());

builder.build().execute();