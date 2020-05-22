public static Cliente jSONToCliente(JSONObject json) throws JSONException{
     // json contain only cliente JSONObject
        Cliente cliente = new Cliente();
        cliente.setId(json.getInt("id"));
        cliente.setNome_fantasia(json.getString("nome_fantasia"));
    return cliente;
}