Map<String, Integer> englishHashMap = new HashMap<String, Integer>();
Map<String, Integer> spanishHashMap = new HashMap<String, Integer>();
Map<String, Integer> hindiHashMap = new HashMap<String, Integer>();

englishHashMap.put("english", 1);
englishHashMap.put("hindi", 2);
englishHashMap.put("telugu", 3);

spanishHashMap.put("english1", 1);
spanishHashMap.put("hindi1", 2);
spanishHashMap.put("telugu1", 3);

hindiHashMap.put("english2", 1);
hindiHashMap.put("hindi2", 2);
hindiHashMap.put("telugu2", 3);

String language = "English";

context.setAttribute("mapEnglish", englishHashMap);
context.setAttribute("mapSpanish", spanishHashMap);
context.setAttribute("mapHindi", hindiHashMap);
context.setAttribute("language", language);