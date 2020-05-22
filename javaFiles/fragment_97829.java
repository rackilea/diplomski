JSONObject json = readJsonFromUrl("http://piggybank.wordmediavormgever.nl/getSaldo.php");
  try {
    String response = json.getString("saldo");
    Log.e("AAAAAAAAA %s", response);

}