language = StandardLanguage {
        name = "org.xtext.example.mydsl.MyDsl"
        fileExtensions = "mydsl"

        serializer = {
            generateStub = false
        }
        validator = {
            // composedCheck = "org.eclipse.xtext.validation.NamesAreUniqueValidator"
        }
        parserGenerator = {
            options = {
                backtrack = true
            }
        }
    }