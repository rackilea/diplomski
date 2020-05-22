@Test
public void testGetAllSettings() {
   Foo fixture = new Foo() {
       public Set<Setting> getUserSettings() { // canned impl }
       public Set<Setting> getOrganizationSettings() { // canned impl }
       public Set<Setting> getDefaults() { // canned impl }
   }

   Assert.assertEquals(whatEverItShouldEqual, fixture.getAllSettings());
}