public class ImportDataObjectFieldSetMapper implements FieldSetMapper<ImportDataObject> {

    @Override
    public ImportDataObject mapFieldSet(final FieldSet fieldSet) throws BindException {
        final ImportDataObject importDataObject = new ImportDataObject();

        importDataObject.setKittenUrl(fieldSet.readString(0));
        importDataObject.setKittenName(fieldSet.readString(1));
        importDataObject.setNumOfReviews(fieldSet.readInt(2));
        importDataObject.setRating(fieldSet.readInt(3));

        importDataObject.setCategories(new ArrayList<String>());
        for (int i = 4; i < fieldSet.getFieldCount(); i++) {
            importDataObject.getCategories().add(fieldSet.readString(i));
        }


        return importDataObject;
    }
}