class Robot {
    private String m_name;

    public void SetName(String name) {
       m_name = name;
    }

    public String GetName() {
       return m_name;
    }

    public void TalkTo(Robot robot, String speech){
        console.writeline(robot.GetName + " says " + speech " to you.");
    }
}

void MyMethod() {
    Robot robotOne = new Robot();  // variable robotOne contains a reference to a robot
    Robot robotTwo = new Robot();  // variable robotTwo contains a reference to another robot
    robotTwo.SetName("Robert");

    // the first robot says hi to the second
    robotOne.TalkTo(robotTwo, "hello");

   // output
   // Robert says hello to you
}