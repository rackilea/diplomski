@Retention(RetentionPolicy.RUNTIME)
@Parameter(in = ParameterIn.PATH,
        name = "FieldId",
        required = true,
        extensions = {@Extension(properties = @ExtensionProperty(name = "custom-type",
                value = "FieldId"))})
public @interface MyAnnotator {
}