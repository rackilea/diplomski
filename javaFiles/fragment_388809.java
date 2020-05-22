Map<String, List<ToA>> wordkey = new HashMap<>();

ToA a = new ToA("Doolin", "Bill", "18580824-1464");
ToA b = new ToA("Dalton", "Bob", "18701005-2232");
ToA c = new ToA("James", "Jesse", "18470905-2401");
ToA d = new ToA("Dalton", "Emmet", "18710713-0818");

wordkey.put("Doolin", Arrays.asList(a));
wordkey.put("James", Arrays.asList(c));
wordkey.put("Dalton", Arrays.asList(b, d));