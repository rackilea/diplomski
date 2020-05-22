Map<String,AcroFields.Item> fields = form.getFields();
AcroFields.Item item;
PdfDictionary dict;
int flags;
for (Map.Entry<String,AcroFields.Item> entry : fields.entrySet()) {
    out.write(entry.getKey());
    item = entry.getValue();
    dict = item.getMerged(0);
    // inspect dict
}