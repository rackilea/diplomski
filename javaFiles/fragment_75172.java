static Map<String, String> replacements = new HashMap<>();
static {
    replacements.put("inv_date", "INVOICE DATE");
    replacements.put("(BaseRate|Rate|tk_rate)", "LINE ITEM UNIT COST");
    // ... more stuff ...
}