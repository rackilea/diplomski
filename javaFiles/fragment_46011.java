@Property
private Map<String, WaiverDetail> waiverDetailMap;

void onPrepareForSubmit() {
    waiverDetailMap = new LinkedHashMap<String, WaiverDetail>();
}