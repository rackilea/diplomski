StrinbBuilder text = new StringBuilder();
boolean first = true;
for (String strGlobalCategory : uniqueCategories) {
    if (!first) {
        text.append(", ");
    }
    first = false;
    text.append (strGlobalCategory);
}
textVisible.setText(text.toSTring());