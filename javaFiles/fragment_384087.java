@Test
public void checkVehicles(@Mocked Vehicle anyCarOrVehicle) {
    new Expectations() {{
        new Vehicle().getName(); result = "mocked vehicle";
        new Car().getName(); result = "mocked car";
    }};

    assertEquals("mocked vehicle", new Vehicle().getName());
    assertEquals("mocked car", new Car().getName());
}