public static void main(String[] args) {

    User user = new User(); 
    Mode.start = true;
    Mode.pause = false; 

    Machine machine = new Machine();
    user.addListener(machine);       


    user.setTimeStart("1:15:30");
    user.setTimePause("1:15:40");
    user.setTimeResume("1:15:50");
    user.setTimeRestart("1:16:00");
    user.setTimeStop("1:16:10");
    //------------------Add this line--------------------
    user.splitAllTimes();  //Add this line to init your attrbutes
}