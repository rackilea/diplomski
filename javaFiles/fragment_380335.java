boolean lockFields(List<PDField> fields, Predicate<PDField> shallBeLocked) {
    boolean isUpdated = false;
    if (fields != null) {
        for (PDField field : fields) {
            boolean isUpdatedField = false;
            if (shallBeLocked.test(field)) {
                field.setFieldFlags(field.getFieldFlags() | 1);
                if (field instanceof PDTerminalField) {
                    for (PDAnnotationWidget widget : ((PDTerminalField)field).getWidgets())
                        widget.setLocked(true);
                }
                isUpdatedField = true;
            }
            if (field instanceof PDNonTerminalField) {
                if (lockFields(((PDNonTerminalField)field).getChildren(), shallBeLocked))
                    isUpdatedField = true;
            }
            if (isUpdatedField) {
                field.getCOSObject().setNeedToBeUpdated(true);
                isUpdated = true;
            }
        }
    }
    return isUpdated;
}