JSONObject json = new JSONObject(readUrl(url.toString()));
if(json.has("natives")) {
   //Logic to extract natives
} else {
   //Logic to extract without natives
}