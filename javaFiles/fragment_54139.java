Citizen c = new Citizen();
WeeklyCare w = new WeeklyCare();
c.getWeeklyCare().add(w);

//The missing link:
w.setCitizen(c);

citizenRepository.save(c);