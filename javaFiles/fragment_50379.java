public class FooCommandArgs {

    @NotNull
    @FileExtension("xml")
    @Content(type=ContentType.XML, value="http://my.schema.location/schema.xsd")
    private IFile xmlFile;

    @NotNull
    @FileExtension("csv")
    private IFile csvFile;

    //getters and setters here ...

}