PDDocument.load(file).use { pdDocument ->
    val acroForm = pdDocument.documentCatalog.acroForm
    acroForm.defaultResources.put(COSName.getPDFName("ArialMT"),
            PDType0Font.load (pdDocument, this.javaClass.classLoader.getResourceAsStream("fonts/ARIALMT.ttf"), false))
    val pdField: PDField? = acroForm.getField(fieldname)
    val value = ...
    when (pdField) {
        is PDCheckBox -> {
            if (value is Boolean) {
                when (value) {
                    true -> pdField.check()
                    false -> pdField.unCheck()
                }
            } else {
                log.error("RENDER_FORM: Need Boolean for ${pdField.fullyQualifiedName} but got $value")
            }
        }
        is PDTextField -> {
            try {
                pdField.value = value?.toString() ?: ""
            } catch (ioException: IOException) {
                pdField.cosObject.setString(COSName.DA, "/Helv 0 Tf 0 g")
                pdField.value = value?.toString() ?: ""
                log.error("RENDER_FORM: Writing text field failed: ${ioException.message}")
            }
        }
        null -> {
            log.error("RENDER_FORMULAR: Formfield $fieldname does not exist in $name")
        }
        else -> log.error("RENDER_FORMULAR: Formfield $pdField ($fieldname) is of unhandled type ${pdField.fieldType}")
    }

    val stream = ByteArrayOutputStream()
    pdDocument.save(stream)
    pdDocument.close()
    return stream.toByteArray()
}