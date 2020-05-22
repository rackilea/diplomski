Object yoda = new Jedi("Yoda", "Green");
Object luke = new Jedi("Luke Skywalker", "Green");

Consumer<Jedi> jediRequirements = jedi -> {
   assertThat(jedi.getLightSaberColor()).isEqualTo("Green");
   assertThat(jedi.getName()).doesNotContain("Dark");
};

assertThat(yoda).isInstanceOfSatisfying(Jedi.class, jediRequirements);
assertThat(luke).isInstanceOfSatisfying(Jedi.class, jediRequirements);