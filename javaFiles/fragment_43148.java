public static Map<String, String> liaToSampa = new HashMap<String, String>();
static {
liaToSampa.put("tt", "t");
liaToSampa.out("ou","u");
liatoSampa.put("jj","Z");
liaToSampa.put("rr","R");
}
// etc

public static String translateLiaToSampa(String liaWord) {
   String result = liaWord;
   for (Map.Entry<String, String> entry : liaToSampa.entrySet()) {
       String liaPhoneme = entry.getKey();
       String sampaPhoneme = entry.getValue();
       result = result.replaceAll(liaPhoneme, sampaPhoneme);
   }
   return result;
}