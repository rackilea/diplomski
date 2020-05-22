JSONObject jObj = new JSONObject(json);
if(jObj != null){
    nama_brg = jObj.getJSONArray("data_gadai_detail").getJSONObject(0).getString(TAG_NAMA_BRG);
    taksiran = jObj.getJSONArray("data_gadai_detail").getJSONObject(0).getString(TAG_TAKSIRAN);
    pinjaman = jObj.getJSONArray("data_gadai_detail").getJSONObject(0).getString(TAG_PINJAMAN);
}