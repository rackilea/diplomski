Scenario Outline:

    Given I create a process
    When I execute the following task <TaskName> with parameters <parameters>
    Then each task <TaskName> should have outcomes <outcomes>
    ***And Last step to run for last scenario 3***

    Examples:
    | TaskName | Parameters | Outcomes |
    | task1 | t1param1,t1param2,t1param3| t1out1,t1out2,t1out3 |
    | task2 | t2param1,t2param2,t2param3| t2out1,t2out2,t2out3 |
    | task3 | t3param1,t3param2,t3param3| t3out1,t3out2,t3out3 |


Include in StepDefinition.java

private Scenario scenario;

@Before
public void before(Scenario sce) {
    this.scenario = sce;
    System.out.println("SCENARIO ID -- " +scenario.getId());
}