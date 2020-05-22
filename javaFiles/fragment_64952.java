ResponseEntry entry = null;
List<ResponseEntry> responseEntries = serviceResponse.getEntryList();
if(responseEntries != null && !responseEntries.isEmpty()){
    entry = responseEntries.stream()
                .filter(e -> "expectedValue".equals(e.getValue()))
                .findFirst()
                .orElse(null);
}