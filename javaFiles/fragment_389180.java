public boolean stopCellEditing() {
        String s = (String)super.getCellEditorValue();
        // Here we are dealing with the case where a user
        // has deleted the string value in a cell, possibly
        // after a failed validation. Return null, so that
        // they have the option to replace the value with
        // null or use escape to restore the original.
        // For Strings, return "" for backward compatibility.
        if ("".equals(s)) {
            if (constructor.getDeclaringClass() == String.class) {
                value = s;
            }
            super.stopCellEditing();
        }

        try {
            value = constructor.newInstance(new Object[]{s});
        }
        catch (Exception e) {
            ((JComponent)getComponent()).setBorder(new LineBorder(Color.red));
            return false;
        }
        return super.stopCellEditing();
    }