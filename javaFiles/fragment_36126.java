p.setSubject("Foo");
p.setVerb("eat");
p.setObject("bar");
p.setFeature(Feature.TENSE, Tense.PAST); 
String output = realiser.realiseSentence(p);
System.out.println(output); // "Foo ate bar"