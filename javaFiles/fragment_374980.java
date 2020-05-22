Map<String,Integer> getDict(int keyId, int valId) {
  String[] keys = getResources().getStringArray(keyId);
  int[] values = getResources().getIntArray(valid); 

  Map<String,Integer> dict = new HashMap<String,Integer>();
  for (int i = 0, l = keys.length; i < l; i++) {
    dict.put(keys[i], vals[i]);
  }

  return dict;
}