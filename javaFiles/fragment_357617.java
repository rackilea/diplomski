stg.setListener(new MySTErrorListener());
try{
    CompiledST compiledTemplate = stg.defineTemplate("receipt", "<an invalid template<>");
} catch (Exception e)
{
    // tell the UI about the error
}