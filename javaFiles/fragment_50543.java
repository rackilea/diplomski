HashMap<String,Verb> maoriToVerb = new HashMap<>();
HashMap<String,Verb> englishToVerb = new HashMap<>();

// create a verb
Verb patu = new Verb();
patu.setMaori("patu");
patu.setEnglish("hit");

// add it to both dictionaries
maoriToVerb.put(patu.getMaori(), patu);
englishToVerb.put(patu.getEnglish(), patu);

// how to get english from maori
String knownMaori = "patu";
Verb retrievedVerbFromMaori = maoriToVerb.get(knownMaori);
String retrievedEnglish = retrievedVerbFromMaori.getEnglish();

// how to get maori from english
String knownEnglish = "hit";
Verb retrievedVerbFromEnglish = englishToVerb.get(knownEnglish);
String retrievedMaori = retrievedVerbFromEnglish.getMaori();