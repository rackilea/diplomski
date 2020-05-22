-    @PATCH
+    @JSONPATCH
    @Path( "manual/{name}" )
    @Consumes( MediaType.APPLICATION_JSON_PATCH_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public JsonObject patchManual( @PathParam( "name" ) String name, JsonStructure patch )