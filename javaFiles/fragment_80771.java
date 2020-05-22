@Mock
private Fixture fixture;

private SimulateBasketballMatchResult simulator;

@Before
public void setUp() {
    simulator = spy(new SimulateBasketballMatchResult(fixture));
    doCallRealMethod().when(simulator).simulate();
}

@Test
public void shouldReturnGoldenStateWarriorsAsWinner() {
    doReturn(0.5).when(simulator).randomDoubleGenerator();
    when(fixture.getHomeTeam()).thenReturn(GOLDEN_STATE_WARRIORS);
    when(fixture.getAwayTeam()).thenReturn(HOUSTON_ROCKETS);

    assertThat(simulator.simulate(MATCH_RESULT_PROBABILITY_MAP), is(GOLDEN_STATE_WARRIORS));
}