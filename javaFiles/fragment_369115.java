private CoalmineCanary coalmineCanary;

@Before
public void setup() {
    coalmineCanary = new CoalmineCanary();
    coalmineCanary.setText("pokus");
    coalmineCanary = canaryRepository.save(coalmineCanary);

    if(coalmineCanary.getId() == 0){
       fail("Could not insert the Canary!");
    }
}

@Test
public void when_loaded_then_entity_is_retrieved() {
    CoalmineCanary managedCanary = canaryRepository.findById(coalmineCanary.getId());
    assertThat(managedCanary).isNotNull();
    assertThat(managedCanary.getText()).isEqualTo("pokus");
}