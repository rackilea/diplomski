@Override
    public void onCreate(Bundle savedInstanceState) {
        super.OnCreate(savedInstanceState);

        // get the robot object sent through to this Activity
        String robotId = getIntent().getStringExtra("robot.id");
        Robot robot = RobotProvider.getDefaultProvider().findRobot(robotId);
    }