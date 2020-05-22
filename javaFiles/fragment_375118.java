List<Scenario> scenarios = new ArrayList();

@Before(order = 0)
public void onScenarioStarted(Scenario scenario)
{
    scenarios.add(Scenario);
}