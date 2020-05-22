// start out with a reasonable pref size, f.i. from a prototype or 
// measuring the actual cell content (both supported by JXTable)
forEachColumn
    column.setPreferredWidth(....);

// then configure the maxWidth proportionally 
private float[] cwidth = { 0.1f, 0.3f, 0.3f, 0.2f, 0.1f };
forEachColumn
    int max = ((int) (1000f * cwidth[columnExt.getModelIndex()]));
    columnExt.setMaxWidth(max);