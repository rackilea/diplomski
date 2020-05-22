person2 = person1;

hs.put(person1, "Durvi");
hs.put(person2, "Pillu"); // since person1 == person2, 
                          // this overwrites the previous key

String personVal = (String)hs.get(person1);