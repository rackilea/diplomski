public void getTwoOverviews() {
    //Contents of method
}

@Test
public void testfindOverviewByStatusTwo() {
    //Setup
    getTwoOverviews();

    List<Overview> scenarioList = scenarioDashboardService.getOverviewByStatus("active");
    assertEquals(2, scenarioList.size());

    String scenarioName = scenarioList.get(0).getScenarioName();
    String scenarioName2 = scenarioList.get(1).getScenarioName();
    assertEquals("first_scenario-test", scenarioName);
    assertEquals("second_scenario-test", scenarioName2);
}