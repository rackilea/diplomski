private List<String> pdfPresets;
private String pdfPreset;

/**
 * Returns a list of pdfPresets
 * @return a List<String> of pdf preset names
 */
public final List<String> getPdfPresets() {
    return pdfPresets;
}

/**
 * Sets the name of the selected pdfPreset
 * (trying to overload setPdfPresets here)
 * @param presetName
 * @see setPdfPreset
 */
public final void setPdfPreset(String presetName) { //renamed method
    // write preset name somehwere else
    pdfPreset = presetName; //use the correct variable
}

/**
 * Sets the pdfPresets
 * @param list
 */
public final void setPdfPresets(List<String> list) {
    pdfPresets = list;
}