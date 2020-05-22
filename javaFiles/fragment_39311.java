new SchemaPrinter(
                  // Tweak the options accordingly
                  SchemaPrinter.Options.defaultOptions()
                          .includeScalarTypes(true)
                          .includeExtendedScalarTypes(true)
                          .includeIntrospectionTypes(true)
                          .includeSchemaDefintion(true)
            ).print(schema);