public static HistoryItem fromJSON(final JSONObject json) {
    HistoryItem item = new HistoryItem();

    item.setStatus(optString("status", json));
    item.setDate(optString("date", json));
    item.setTime(optString("time", json));
    item.setNumber(optString("number", json));
    item.setAmount(optString("amount", json));
    item.setDescription(optString("description", json));
    item.setIncoming(optString("incoming", json));
    item.setAccount(optString("account", json));
    item.setName(optString("name", json));

    return item;
}