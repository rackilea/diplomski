@Override
protected void onPostExecute(Map<Integer,List<String>> output) {
      pd.dismiss();
      Logger.l(Logger.TAG_DBG, "Setting adapter...");
      listView.setAdapter(new QuotesArrayAdapter(HTMLParser.this,
          quotes));
}