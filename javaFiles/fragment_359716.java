String[][] table;
JsonParser parser = new JsonParser();
JsonObject obj = parser.parse(document.text()).getAsJsonObject();
JsonArray array = obj.get("movimientos").getAsJsonArray();
table = new String[3][array.size()];
for (int i = 0; i < array.size(); i++) {
    JsonObject element = array.get(i).getAsJsonObject();
    table[0][i] = element.get("fechaDatetime").getAsString();
    table[1][i] = element.get("movimiento").getAsString();
    table[2][i] = element.get("ubicacion").getAsString();
}